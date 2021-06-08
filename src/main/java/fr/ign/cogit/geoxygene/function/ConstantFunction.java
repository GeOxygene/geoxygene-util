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
 * @author JeT Simple constant function parameterized by the shift
 */
@XmlRootElement(name = "ConstantFunction")
public class ConstantFunction extends AbstractFunction1D {

  @XmlElement(name="shift")
  private double shift = 1.; // constant shift (Y translation factor)

    /**
     * Constructor.
     */
    public ConstantFunction() {
        super();
    }
    
    /**
     * Renvoi la constante.
     * 
     * @return Shift
     */
    public double getShift() {
      return shift;
    }

    /**
     * Constructor.
     * 
     * @param shift
     *            Y shift value
     */
    public ConstantFunction(final double shift) {
        super();
        this.shift = shift;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.ign.cogit.geoxygene.function.Function1D#help()
     */
    @Override
    public String help() {
        return "f(x) = C. C real value";
    }

    
    
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * fr.ign.cogit.geoxygene.appli.render.gl.GeoDisplacementFunction1D#displacement
     * (double)
     */
    @Override
    public Double evaluate(final double parameter) {
        return this.shift;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Constant[" + this.shift + "]";
    }
    
    

}
