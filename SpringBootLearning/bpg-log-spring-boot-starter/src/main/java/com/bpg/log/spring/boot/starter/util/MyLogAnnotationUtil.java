package com.bpg.log.spring.boot.starter.util;

import org.aspectj.lang.JoinPoint;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author zhaohq
 * @date 2020/10/9
 **/
public class MyLogAnnotationUtil {
    /**
     * 解析EL表达式
     *
     * @param expressionString 表达式
     * @param method           方法
     * @param args             参数
     * @return string
     */
    public String myParseExpression(String expressionString, Method method, Object[] args) {
        //获取被拦截方法参数名列表
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNameArr = discoverer.getParameterNames(method);
        //SPEL解析
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < Objects.requireNonNull(paramNameArr).length; i++) {
            context.setVariable(paramNameArr[i], args[i]);
        }
        return parser.parseExpression(expressionString).getValue(context, String.class);
    }

    /**
     * 获取这个方法上的所有注解
     *
     * @param method method
     * @return string
     */

    public String getAllAnnotation(Method method) {
        Annotation[] annotations = method.getDeclaredAnnotations();
        // 保存获取的注解
        StringBuilder annotationsName = new StringBuilder();
        String printFormat = "";
        for (Annotation annotation : annotations) {
            // 获取注解的具体类型
            Class<? extends Annotation> annotationType = annotation.annotationType();
            annotationsName.append(printFormat);
            annotationsName.append(annotationType.getCanonicalName());
            printFormat = '\n' + "                   ";
        }
        return annotationsName.toString();
    }

    /**
     * 获取该方法的所有参数
     *
     * @param joinPoint 切点
     * @return string
     */
    public String getAllArgs(JoinPoint joinPoint) {
        // 获取该方法的参数
        Object[] args = joinPoint.getArgs();
        StringBuilder argsValue = new StringBuilder();
        String printFormat = "";
        for (Object obj : args) {
            argsValue.append(printFormat);
            argsValue.append(obj);
            printFormat = '\n' + "                   ";
        }
        return argsValue.toString();
    }

    /**
     * 获取类上特定的注解
     *
     * @param clazz      类
     * @param annotation 注解
     * @return annotation
     */
    private Annotation get(Class<?> clazz, Class<? extends Annotation> annotation) {
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        for (Annotation a : annotations) {
            if (annotation == a.annotationType()) {
                return a;
            }
        }
        return null;
    }

    /**
     * 获取方法上的特定的注解
     *
     * @param method     method
     * @param annotation annotation 注解
     * @return annotation
     */
    public Annotation get(Method method, Class<? extends Annotation> annotation) {
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation a : annotations) {
            if (annotation == a.annotationType()) {
                return a;
            }
        }
        return null;
    }

    /**
     * 拼接URL
     *
     * @param clazz  类
     * @param method 方法
     * @return string
     */
    public String getUrl(Class<?> clazz, Method method) {
        // 获取类上的url和方法上的url拼接
        String clazzUrl = "";
        String methodUrl = "";
        try {
            // 类上requestMapping 的 url value
            if (get(clazz, RequestMapping.class) != null) {
                clazzUrl = Arrays.toString(clazz.newInstance().getClass().getAnnotation(RequestMapping.class).value());
                clazzUrl = clazzUrl.replace("[","");
                clazzUrl = clazzUrl.replace("]","");
            }
            // 方法上requestMapping 的 url value
            if (get(method, GetMapping.class) != null) {
                methodUrl = Arrays.toString(method.getAnnotation(GetMapping.class).value());
                methodUrl = methodUrl.replace("[","");
                methodUrl = methodUrl.replace("]","");
                return clazzUrl + methodUrl;
            }
            if (get(method, PostMapping.class) != null) {
                methodUrl = Arrays.toString(method.getAnnotation(PostMapping.class).value());
                methodUrl = methodUrl.replace("[","");
                methodUrl = methodUrl.replace("]","");
                return clazzUrl + methodUrl;
            }
            if (get(method, RequestMapping.class) != null) {
                methodUrl = Arrays.toString(method.getAnnotation(RequestMapping.class).value());
                methodUrl = methodUrl.replace("[","");
                methodUrl = methodUrl.replace("]","");
                return clazzUrl + methodUrl;
            }
            if (get(method, PutMapping.class) != null) {
                methodUrl = Arrays.toString(method.getAnnotation(PutMapping.class).value());
                methodUrl = methodUrl.replace("[","");
                methodUrl = methodUrl.replace("]","");
                return clazzUrl + methodUrl;
            }
            if (get(method, DeleteMapping.class) != null) {
                methodUrl = Arrays.toString(method.getAnnotation(DeleteMapping.class).value());
                methodUrl = methodUrl.replace("[","");
                methodUrl = methodUrl.replace("]","");
                return clazzUrl + methodUrl;
            }
            if (get(method, PatchMapping.class) != null) {
                methodUrl = Arrays.toString(method.getAnnotation(PatchMapping.class).value());
                methodUrl = methodUrl.replace("[","");
                methodUrl = methodUrl.replace("]","");
                return clazzUrl + methodUrl;
            }

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return clazzUrl + methodUrl;

    }

    /**
     * 获取
     *
     * @param method 方法
     * @return string 请求方式
     */
    public String getRequestMethod(Method method) {
        String post = "PostMapping";
        String get = "GetMapping";
        String put = "PutMapping";
        String delete = "DeleteMapping";
        String patch = "PatchMapping";
        String request = "RequestMapping";
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.toString().contains(post)) {
                return "POST";
            }
            if (annotation.toString().contains(get)) {
                return "GET";
            }
            if (annotation.toString().contains(put)) {
                return "PUT";
            }
            if (annotation.toString().contains(delete)) {
                return "DELETE";
            }
            if (annotation.toString().contains(patch)) {
                return "PATCH";
            }
            if (annotation.toString().contains(request)) {
                return "RequestMapping";
            }
        }
        return null;
    }
}
