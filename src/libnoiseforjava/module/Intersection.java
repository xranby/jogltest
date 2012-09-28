/*
 * Copyright (C) 2003, 2004 Jason Bevins (original libnoise code)
 * Copyright  2010 Thomas J. Hodge (java port of libnoise)
 * Copyright 2012 Michael Nugent (This module)
 *
 * This file is part of libnoiseforjava.
 *
 * libnoiseforjava is a Java port of the C++ library libnoise, which may be found at
 * http://libnoise.sourceforge.net/.  libnoise was developed by Jason Bevins, who may be
 * contacted at jlbezigvins@gmzigail.com (for great email, take off every 'zig').
 * Porting to Java was done by Thomas Hodge, who may be contacted at
 * libnoisezagforjava@gzagmail.com (remove every 'zag').
 *
 * libnoiseforjava is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * libnoiseforjava is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * libnoiseforjava.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package libnoiseforjava.module;

import libnoiseforjava.exception.ExceptionInvalidParam;

/**
 * User: mike nugent
 * Date: 2/18/12
 * Time: 11:57 PM
 * URL: https://github.com/michaelnugent/libnoiseforjava
 * Package: libnoiseforjava.module
 */
public class Intersection extends ModuleBase {
    double cutoff;
    public Intersection(ModuleBase sourceModuleOne, ModuleBase sourceModuleTwo, double cutoff) throws ExceptionInvalidParam
    {
        super(2);
        setSourceModule(0, sourceModuleOne);
        setSourceModule(1, sourceModuleTwo);
        this.cutoff = cutoff;
    }

    public double getValue (double x, double y, double z)
    {
        assert (sourceModules[0] != null);
        assert (sourceModules[1] != null);

        double s1 = sourceModules[0].getValue(x,y,z);
        double s2 = sourceModules[1].getValue(x,y,z);

        if ( s1 + cutoff > s2 && s1 - cutoff < s2 ) {
            return s1;
        }
        else {
            return -1;
        }
    }
}