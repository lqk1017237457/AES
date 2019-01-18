package AES;
public class Test {
	public static void main(String[] args) {
		byte[] plain = {
				(byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x01, 
				(byte) 0x01, (byte) 0xa1, (byte) 0x98, (byte) 0xaf, 
				(byte) 0xda, (byte) 0x78, (byte) 0x17, (byte) 0x34, 
				(byte) 0x86, (byte) 0x15, (byte) 0x35, (byte) 0x66
		};
		byte[] key = {
				(byte) 0x00, (byte) 0x01, (byte) 0x20, (byte) 0x01, 
				(byte) 0x71, (byte) 0x01, (byte) 0x98, (byte) 0xae, 
				(byte) 0xda, (byte) 0x79, (byte) 0x17, (byte) 0x14, 
				(byte) 0x60, (byte) 0x15, (byte) 0x35, (byte) 0x94
		};
		word[] plaintext = toWordArr(plain);
		System.out.println("明文：" + wordArrStr(plaintext));
		word[] CipherKey = toWordArr(key);
		System.out.println("密钥：" + wordArrStr(CipherKey));
		word[] cipherText = AES.encrypt(plaintext, CipherKey);
		System.out.println("密文：" + wordArrStr(cipherText));
		word[] newPlainText = AES.decrypt(cipherText, CipherKey);
		System.out.println("明文：" + wordArrStr(newPlainText));
	}

	static word[] toWordArr(byte[] b) {
		int len = b.length / 4;
		if (b.length % 4 != 0) len++;
		word[] w = new word[len];
		for (int i = 0; i < len; i++) {
			byte[] c = new byte[4];
			if (i * 4 < b.length) {
				for (int j = 0; j < 4; j++)
					c[j] = b[i * 4 + j];
			}
			w[i] = new word(c);
		}
		return w;
	}

	static String wordArrStr(word[] w) {
		String str = "";
		for (word word : w)
			str += word;
		return str;
	}
}