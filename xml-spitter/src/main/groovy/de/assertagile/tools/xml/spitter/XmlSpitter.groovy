package de.assertagile.tools.xml.spitter

import groovy.util.slurpersupport.GPathResult
import groovy.xml.MarkupBuilder

/**
 * Created by mkutz on 06.06.14.
 */
class XmlSpitter {

    private StringWriter writer
    private MarkupBuilder markupBuilder

    public XmlSpitter(StringWriter writer = new StringWriter()) {
        this.writer = writer
        this.markupBuilder = new MarkupBuilder(writer)
    }

    public String marshall(Map map) {
        map.each { key, value ->
            if (value instanceof Map) {
                markupBuilder."${key}" mapToClosure(value as Map)
            } else {
                markupBuilder."${key}" value
            }
        }
        writer.toString()
    }

    private Closure mapToClosure(Map map) {
        return {

        }
    }
}
