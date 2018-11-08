package org.vincent.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * FirstAction 基于继承 方式，继承 ActionSupport类；
 * form 提交的表单数据 和 Action 对应的属性是一一对应的。
 * 在Action中，Preparable接口执行时机, Preparable接口的prepare()方法的执行点是在：setXxx()属性 和 execute()的执行之前
 * @author PengRong
 * @date 2018/9/12
 */
public class FirstAction extends ActionSupport  implements Preparable{
    @Override
    public String execute() throws Exception {

        // 如果代码数和是非负整数，跳到positive.jsp页面
        if (getSum() >= 0)
        {
            return "positive";
        }
        else  // 如果代码数和是负整数，跳到negative.jsp页面
        {
            return "negative";
        }

    }

    private int operand1;
    private int operand2;


    public int getOperand1()
    {
        return operand1;
    }

    public void setOperand1(int operand1)
    {
        System.out.println(operand1);
        this.operand1 = operand1;
    }

    public int getOperand2()
    {
        return operand2;
    }
    public void setOperand2(int operand2)
    {
        System.out.println(operand2);
        this.operand2 = operand2;
    }
    public int getSum()
    {
        return operand1 + operand2;  // 计算两个整数的代码数和
    }

    /**
     * This method is called to allow the action to prepare itself.
     *
     * @throws Exception thrown if a system level exception occurs.
     */
    @Override
    public void prepare() throws Exception {
        System.out.println("prepare 执行");
        System.out.println("prepare operand1 "+operand1);
        System.out.println("prepare operand2 "+operand2);
    }
}
