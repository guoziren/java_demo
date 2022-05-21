package com.ustc.expression;

import com.google.common.collect.Lists;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AviatorTest {
    @Test
    public void test() {
        // exec执行方式，无需传递Map格式
        String age = "18";
        System.out.println(AviatorEvaluator.exec("'His age is '+ age +'!'", age));



        // execute执行方式，需传递Map格式
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("age", "18");
        System.out.println(AviatorEvaluator.execute("'His age is '+ age +'!'",
                map));

        AbstractFunction function;

    }


    @Test
    public void test2() {
        // 注册自定义函数
        AviatorEvaluator.addFunction(new MultiplyFunction());
        // 方式1
        System.out.println(AviatorEvaluator.execute("multiply(12.23, -2.3)"));
        // 方式2
        Map<String, Object> params = new HashMap<>();
        params.put("a", 12.23);
        params.put("b", -2.3);
        System.out.println(AviatorEvaluator.execute("multiply(a, b)", params));
    }

    @Test
    public void testInclude() {
        List<String> tags = Lists.newArrayList("广东","江西");
        System.out.println(AviatorEvaluator.execute("include(tags, \"广东\")"));
    }

    @Test
    public void tes3() {
//        String expression = "a + (b - c) > 100 && b >= 44.99999";
        String expression = "(a + (b - c) > 100 && b >= 45.99999) || (a + (b - c) > 100 && b >= 45.99999)";
        // 编译表达式
        Expression compiledExp = AviatorEvaluator.compile(expression);

        Map<String, Object> env = new HashMap<>();
        env.put("a", 100.3);
        env.put("b", 45);
        env.put("c", -199.100);

        // 执行表达式
        Boolean result = (Boolean) compiledExp.execute(env);
        System.out.println(result);
    }

    class MultiplyFunction extends AbstractFunction{
        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {

            double num1 = FunctionUtils.getNumberValue(arg1, env).doubleValue();
            double num2 = FunctionUtils.getNumberValue(arg2, env).doubleValue();
            return new AviatorDouble(num1 * num2);
        }

        @Override
        public String getName() {
            return "multiply";
        }

    }

}