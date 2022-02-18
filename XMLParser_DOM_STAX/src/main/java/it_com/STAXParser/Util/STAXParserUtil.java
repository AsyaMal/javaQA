package it_com.STAXParser.Util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class STAXParserUtil {

    private static final String XML_PATH = "journal.xml";

    public static XMLStreamReader getXMLStreamReader() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            return factory.createXMLStreamReader(
                    ClassLoader.getSystemResourceAsStream(XML_PATH));
        } catch (XMLStreamException e) {
            System.out.println("XMLStreamException error");
            e.printStackTrace();
            return null;
        }
    }
}

