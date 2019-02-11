package cn.kspshare.common;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: JsonUtils
 * @author hanwl
 * @date 2019年01月22日
 * @Description: TODO
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Json格式的字符串向JavaBean转换，传入空串将返回null
     * @param strBody Json格式的字符串
     * @param c 目标JavaBean类型
     * @return JavaBean对象
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> T json2Object(String strBody, Class<T> c) throws JsonParseException, JsonMappingException, IOException{
        if (strBody == null || "".equals(strBody)) {
            return null;
        }
        else {
            return OBJECT_MAPPER.readValue(strBody, c);
        }
    }

    /**
     * Json格式的字符串向JavaBean转换，传入空串将返回null
     * @param strBody Json格式的字符串
     * @param c 目标JavaBean类型
     * @return JavaBean对象, 如果解析失败返回 null
     */
    public static <T> T decodeJson(String strBody, Class<T> c) {
        if (strBody == null || "".equals(strBody)) {
            return null;
        }
        else {
            try {
                return OBJECT_MAPPER.readValue(strBody, c);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /**
     *
     * @param strBody
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static Object json2ComplexObject(String strBody) throws JsonParseException, JsonMappingException, IOException{
        if (strBody == null || "".equals(strBody)) {
            return null;
        }
        else {
            // 每个属性的实际类型是string
            return OBJECT_MAPPER.readValue(strBody, Object.class);
        }
    }

    /**
     * Json格式的字符串向JavaBean List集合转换，传入空串将返回null
     * @param strBody
     * @param c
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> json2ObjectList(String strBody,Class<T> c) throws JsonParseException, JsonMappingException, IOException{
        if (strBody == null || "".equals(strBody)) {
            return null;
        }
        else {
            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(ArrayList.class, c);
            return (List<T>) OBJECT_MAPPER.readValue(strBody, javaType);
        }
    }

    /**
     * Json格式的字符串向JavaBean List集合转换，传入空串将返回null
     * @param strBody
     * @param c
     * @return 对象列表，解析失败返回 null
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> decodeJsonToList(String strBody,Class<T> c) {
        if (strBody == null || "".equals(strBody)) {
            return null;
        }
        else {
            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(ArrayList.class, c);
            try {
                return (List<T>) OBJECT_MAPPER.readValue(strBody, javaType);
            } catch (IOException e) {
                e.printStackTrace();

                return null;
            }
        }
    }

    /**
     * Json格式的字符串向List<String>集合转换，传入空串将返回null
     * @param strBody
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static List<String> json2List(String strBody) throws JsonParseException, JsonMappingException, IOException{
        return json2ObjectList(strBody, String.class);
    }

    /**
     * Object转为Json格式字符串的方法
     * @param o
     * @return
     * @throws JsonProcessingException
     */
    public static String object2Json(Object o) throws JsonProcessingException{
        return OBJECT_MAPPER.writeValueAsString(o);
    }

    /**
     * Object转为Json格式字符串的方法
     * @param o
     * @return 对象的json字符串，如果处理过程中出错，返回null
     */
    public static String encodeObject(Object o) {
        try {
            return OBJECT_MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}