package test;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author xxl
 * @category jaxb2工具类
 * 
 *           Jaxb2实现JavaBean与xml互转
 * 
 *           一、简介
 * 
 *           JAXB（Java Architecture for XML Binding) 是一个业界的标准，是一项可以根据XML
 *           Schema产生Java类的技术。该过程中，JAXB也提供了将XML实例文档反向生成Java对象树的方法，
 *           并能将Java对象树的内容重新写到 XML实例文档。
 * 
 *           Jaxb 2.0是JDK 1.6的组成部分。我们不需要下载第三方jar包
 *           即可做到轻松转换。Jaxb2使用了JDK的新特性，如：Annotation、GenericType等，
 *           需要在即将转换的JavaBean中添加annotation注解。
 * 
 * 
 * 
 *           二、重要概念
 * 
 *           JAXBContext类，是应用的入口，用于管理XML/Java绑定信息。
 *           Marshaller接口，将Java对象序列化为XML数据。 Unmarshaller接口，将XML数据反序列化为Java对象。
 * 
 * 
 * @XmlType，将Java类或枚举类型映射到XML模式类型 @XmlAccessorType(XmlAccessType.FIELD)
 *                                ，控制字段或属性的序列化。
 *                                FIELD表示JAXB将自动绑定Java类中的每个非静态的（static）、
 *                                非瞬态的（由@XmlTransient标
 *                                注）字段到XML。其他值还有XmlAccessType.
 *                                PROPERTY和XmlAccessType.NONE。
 * @XmlAccessorOrder，控制JAXB 绑定类中属性和字段的排序。 @XmlJavaTypeAdapter，使用定制的适配器（
 *                          即扩展抽象类XmlAdapter并覆盖marshal()和unmarshal()方法），
 *                          以序列化Java类为XML。 @XmlElementWrapper
 *                          ，对于数组或集合（即包含多个元素的成员变量），生成一个包装该数组或集合的XML元素（称为包装器）
 *                          。 @XmlRootElement ，将Java类或枚举类型映射到XML元素。 @XmlElement，
 *                          将Java类的一个属性映射到与属性同名的一个XML元素。 @XmlAttribute，
 *                          将Java类的一个属性映射到与属性同名的一个XML属性。
 * 
 */
public class JaxbUtil {

	/**
	 * JavaBean转换成xml
	 * 
	 * @param obj
	 * @return
	 */
	public static String convertToXml(Object obj) {
		return convertToXml(obj, "UTF-8");
	}

	/**
	 * JavaBean转换成xml
	 * 
	 * @param obj
	 * @param encoding
	 * @return
	 */
	public static String convertToXml(Object obj, String encoding) {
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			result = writer.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * xml转化成JavaBean
	 * 
	 * @param xml
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T converyToJavaBean(String xml, Class<T> c) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return t;
	}

}
