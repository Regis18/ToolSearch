package com.jala.convertor.models;

/**
 * Interface allows that other classes can implement distinct form of conversion.
 *
 * @version 0.0.1
 * @author Areliez Vargas
 */
public interface IConvertible {

    /**
     * This method allows changes an image by criteria set.
     * @param criteriaConvertor to convert.
     */
    void convert(CriteriaConvertor criteriaConvertor);
}
