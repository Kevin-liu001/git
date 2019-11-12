/**
 * @文件名:
 * @类功能说明:
 * @作者: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @日期:
 * @修改说明:<br> <pre>
 * 	 <li>作者: LiuKaiWem</li>
 * 	 <li>日期: </li>
 * 	 <li>内容: </li>
 * </pre>
 */

    public class Test {
        static int sum(int i) { /* 定义变量 */
            int a=0;
            if (i == 1) /* 假设条件 */
                return 1;
            else {
                a = i + sum(i - 1); /* 1~100的和的表达式 */
                return a; /* 返回结果 */
            }
        }
        public static void main(String[] args) {
            System.out.println(sum(100));//結果5050
        }
    }


