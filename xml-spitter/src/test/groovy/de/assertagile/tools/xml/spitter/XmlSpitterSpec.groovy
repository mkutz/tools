package de.assertagile.tools.xml.spitter

import spock.lang.Specification
import spock.lang.Subject


/**
 * Created by mkutz on 06.06.14.
 */
class XmlSpitterSpec extends Specification {

    XmlSlurper slurper = new XmlSlurper()

    @Subject
    XmlSpitter spitter = new XmlSpitter()

    def "xml spitter should produce to original XML to a slurped one"(String xml) {
        expect:
        spitter.marshall(slurper.parseText(xml) as Map) == xml

        where:
        xml << ["<a><b><c>text</c></b></a>"]
    }

}