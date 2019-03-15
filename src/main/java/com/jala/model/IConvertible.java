/**
 * @(#) IConvertible.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model;

/**
 * Interface allows that other classes can implement distinct form of conversion.
 *
 * @version 0.0.3
 * @author Areliez Vargas
 * @author Regis Humana
 */
public interface IConvertible <T> {

    /**
     * This method allows changes an image by whatever object.
     * @param criteriaConverter to convert.
     */
    <T> void convert(T criteriaConverter);
}
