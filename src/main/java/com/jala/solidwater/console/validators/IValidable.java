/**
 * @(#)IValidable.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.solidwater.console.validators;

/**
 * This interface allows validate.
 *
 * @author Areliez Vargas.
 * @version 0.0.1
 */
public interface IValidable<T> {

    /**
     * This method allows validate a set of arguments.
     *
     * @param argument to validate the T.
     * @return true if argument is valid, false if argument isn't valid.
     */
    boolean validate(T argument);
}
