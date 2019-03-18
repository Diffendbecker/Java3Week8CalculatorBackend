package com.akomlev.Rest;

public class CalculatorService {
    public String Calculate(String expression) throws Exception
    {
        try {
            char[] expressoinChars = expression.toCharArray();
            String value1 = "";
            String value2 = "";
            String action = "";

            boolean isFirstValueDone = false;

            for (int x = 0; x < expressoinChars.length; x++)
            {
                if(Character.isDigit(expressoinChars[x]) || expressoinChars[x] == '.' || (x==0 && expressoinChars[x] == '-') || (isFirstValueDone && expressoinChars[x] == '-'))
                {
                    if(isFirstValueDone == false)
                    {
                        value1 += expressoinChars[x];
                    }
                    else
                    {
                        value2 += expressoinChars[x];
                    }
                }
                else
                {
                    isFirstValueDone = true;
                    action = String.valueOf(expressoinChars[x]);
                }
            }

            action = action.trim();
            float value1Converted = Float.parseFloat(value1.trim());
            float value2Converted = Float.parseFloat(value2.trim());

            return CalculateTwoValues(value1Converted, value2Converted, action);
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }
    }

    public String CalculateTwoValues(float mValueOne, float mValueTwo, String action)
    {
        if(action.equals("|") && mValueTwo == 0)
        {
            return "Divide to 0 is illegal.";
        }

        if (action.equals("+")) {
            float plusResult = mValueOne + mValueTwo;

            if((plusResult-(int)plusResult)==0) {
                int plusIntResult = Math.round(mValueOne + mValueTwo);
                return plusIntResult + "";
            }
            else
            {
                return mValueOne + mValueTwo + "";
            }
        }

        if (action.equals("-")) {
            float minusResult = mValueOne - mValueTwo;
            if((minusResult-(int)minusResult)==0) {
                int minusIntResult = Math.round(mValueOne - mValueTwo);
                return minusIntResult + "";
            }
            else
            {
                return mValueOne - mValueTwo + "";
            }
        }

        if (action.equals("*")) {
            float multiplyResult = mValueOne * mValueTwo;
            if((multiplyResult-(int)multiplyResult)==0) {
                int multiplyIntResult = Math.round(mValueOne * mValueTwo);
                return multiplyIntResult + "";
            }
            else
            {
                return mValueOne * mValueTwo + "";
            }
        }

        if (action.equals("|")) {

            float divideResult = mValueOne / mValueTwo;
            if((divideResult-(int)divideResult)==0) {
                int divideIntResult = Math.round(mValueOne / mValueTwo);
                return divideIntResult + "";
            }
            else
            {
                return mValueOne / mValueTwo + "";
            }
        }

        return "Action is unknown";
    }
}
