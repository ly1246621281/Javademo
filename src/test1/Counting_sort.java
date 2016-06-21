package test1;

public class Counting_sort {

	public static void main(String[] args) {
		int[] input = new int[10];
		int k = 5;// ����Ԫ�ض��ǽ���0��k֮��
		// ��������������飬����Ԫ�ض�����0��k֮��
		for (int i = 0; i < input.length; i++) {
			input[i] = (int) (Math.random() * k);// ���ַ�Χ[0,k)
		}
		System.out.print("��������");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		int[] output = new int[input.length];
		countsort(input, output, k);
		System.out.print("�������");
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}

	}

	public static void countsort(int[] input, int[] output, int k) {
		// inputΪ�������飬outputΪ������飬k��ʾ�����������ֶ�����0��k֮��
		int[] c = new int[k];// ��ʱ�洢��
		int len = c.length;
		// ��ʼ��
		for (int i = 0; i < len; i++) {
			c[i] = 0;
		}
		// ���ÿ������Ԫ�أ����һ������Ԫ�ص�ֵΪinput[i],��ôc[input[i]]��ֵ��1���˲�����ɺ�c[i]�д����ֵΪi��Ԫ�صĸ���
		for (int i = 0; i < input.length; i++) {
			c[input[i]]++;
		}
		// ͨ����c�м�¼�����ͣ�c[i]�д�ŵ���С�ڵ���iԪ�ص����ָ���
		for (int i = 1; i < len; i++) {
			c[i] = c[i] + c[i - 1];
		}
		// �����������е�Ԫ�ط�����������ж�Ӧ��λ����
		for (int i = input.length - 1; i >= 0; i--) {// �Ӻ���ǰ����
			output[c[input[i]] - 1] = input[i];
			c[input[i]]--;// �ò���ʹ����һ��ֵΪinput[i]��Ԫ��ֱ�ӽ������������input[i]��ǰһ��λ��
		}
	}

}
