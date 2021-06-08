/*******************************************************************************
 * This file is part of the GeOxygene project source files.
 * 
 * GeOxygene aims at providing an open framework which implements OGC/ISO
 * specifications for the development and deployment of geographic (GIS)
 * applications. It is a open source contribution of the COGIT laboratory at the
 * Institut Géographique National (the French National Mapping Agency).
 * 
 * See: http://oxygene-project.sourceforge.net
 * 
 * Copyright (C) 2005 Institut Géographique National
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library (see file LICENSE if present); if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307 USA
 *******************************************************************************/
package fr.ign.cogit.geoxygene.function;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author JeT linear function a*x+b parameterized by a and b
 */
@XmlRootElement(name = "LinearFunction")
public class LinearFunction extends AbstractFunction1D {

  @XmlElement(name="a")
  private double a = 1.; // a parameter
  
  @XmlElement(name="b")
  private double b = 0.; // b parameter

    /**
     * Constructor
     */
    public LinearFunction() {
        super();
    }

    /**
     * Constructor
     * 
     * @param a
     *            a parameter
     * @param b
     *            b parameter
     */
    public LinearFunction(final double a, final double b) {
        super();
        this.a = a;
        this.b = b;
    }
    
    /**
     * Renvoi la pente de l'équation.
     * 
     * @return a
     */
    public double getA() {
      return a;
    }
    
    /**
     * Renvoi l'abscisse à l'origine.
     * 
     * @return b
     */
    public double getB() {
      return b;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.ign.cogit.geoxygene.function.Function1D#help()
     */
    @Override
    public String help() {
        return "f(x)=a*x+b. a,b real values";
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * fr.ign.cogit.geoxygene.appli.render.gl.GeoDisplacementFunction1D#displacement
     * (double)
     */
    @Override
    public Double evaluate(final double x) throws FunctionEvaluationException {
        try {
            return this.a * x + this.b;
        } catch (Exception e) {
            throw new FunctionEvaluationException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Linear[" + this.a + "," + this.b + "]";
    }

}
