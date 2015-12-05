/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012-2015 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package org.learn.annotation;

import org.learn.model.Address;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidAddress.Validator.class)
public @interface ValidAddress {

    String message() default "{Invalid address: Check your "
    		+ "								phone number or zip code}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<ValidAddress, Address> {

        //Valid phone number (123) 123-1234
        // Invalid phone number not (123)123-1234.
        private String US_PHONE_PATTERN =
        		"^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$";
        //A valid postal code should match 12345 and 12345-6789,
        // but not 1234, 123456, 123456789, or 1234-56789.
        private String US_ZIP_PATTERN = "^[0-9]{5}(?:-[0-9]{4})?$";

        @Override
        public void initialize(final ValidAddress hasId) {
        }

        @Override
        public boolean isValid(final Address address, final
        			ConstraintValidatorContext constraintValidatorContext) {
            Matcher matcher;
            Pattern pattern = Pattern.compile(US_ZIP_PATTERN);
            matcher = pattern.matcher(address.getZip());
            if(!matcher.matches())
                return false;

            pattern = Pattern.compile(US_PHONE_PATTERN);
            matcher = pattern.matcher(address.getPhone());
            if(!matcher.matches())
                return false;

            return true;
        }
    }
}
