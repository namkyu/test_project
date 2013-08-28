package api.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;


/**
 * @FileName : PropertiesTest.java
 * @Project : test_project
 * @Date : 2012. 11. 22.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class PropertiesTest {

	private Properties prop;

	@Before
	public void init() throws IOException {
//		InputStream is = this.getClass().getResourceAsStream("conf.properties");
//		Properties properties = new Properties();
//		properties.load(is);
//		prop = properties;

		InputStream stream = PropertiesTest.class.getResourceAsStream("conf.properties");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		Properties properties = new Properties();
		properties.load(reader);
		prop = properties;
	}

	@Test
	public void getPropertyTest() throws IOException {
		String value = prop.getProperty("first.name");
		assertThat(value, is("namkyu"));
	}

	@Test
	public void getPropertyDefaultValueTest() {
		String test = prop.getProperty("firstName");
		assertThat(test, nullValue());

		String value = prop.getProperty("firstName", "defaultValue");
		assertThat(value, is("defaultValue"));
	}

	@Test
	public void listTest() {
		PrintStream ps = new PrintStream(System.out);
		prop.list(ps);
	}

	@Test
	public void loadFromXmlTest() throws InvalidPropertiesFormatException, IOException {
		InputStream stream = PropertiesTest.class.getResourceAsStream("conf.xml");
		prop.loadFromXML(stream);

		assertThat(prop, notNullValue());
		assertThat(prop.getProperty("name"), is("namkyu"));
		assertThat(prop.getProperty("age"), is("31"));
		assertThat(prop.getProperty("html"), is("<span>11111</span>"));
		assertThat(prop.getProperty("subject"), is("제목"));
	}

	@Test
	public void propertiesNamesTest() {
		Enumeration<?> it = prop.propertyNames();
		while (it.hasMoreElements()) {
			String propKey = (String) it.nextElement();
			assertThat(propKey, notNullValue());
		}
	}

	@Test
	public void setPropertyTest() {
		prop.setProperty("setTest", "2222");
		assertThat(prop.getProperty("setTest"), is("2222"));
	}

	@Test
	public void stringPropertyNamesTest() {
		Iterator<String> it = prop.stringPropertyNames().iterator();
		while (it.hasNext()) {
			String name = it.next();
			assertThat(name, notNullValue());
		}
	}

	@Test
	public void storeToXmlTest() throws IOException {
		File file = new File("c:\\propToXml.xml");
		OutputStream os = new FileOutputStream(file);
		prop.storeToXML(os, "test입니다.", "UTF-8");

		os.close();
//		assertThat(file.delete(), is(true));
	}

}
