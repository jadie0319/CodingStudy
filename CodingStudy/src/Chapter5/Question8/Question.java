package Chapter5.Question8;





/*
 * 5-8 선 그리기 : 흑백 모니터 화면은 하나의 바이트 배열에 저장되는데, 인접한 픽셀
 * 여덞 개를 한 바이트에 묶어서 저장한다. 화면의 포은 w이며, w는 8로 나누어 떨어진다
 * (따라서 어떤 바이트도 두 행에 걸치지 않는다). 물론, 화면 높이는 배열 길이와 화면 폭을 통해 
 * 유도해 낼 수 있다. 이때 (x1,y)에서 (x2,y)까지 수평선을 그려주는 함수를 작성하라.
 * 메서드 용법은 다음과 같다
 * drawLine(byte[] screen, int width, int x1, int x2, int y)
 * 
 * 
 *	Very hard... To be continue...
 */

public class Question {
	public static int computeByteNum(int width, int x, int y) {
		return (width * y + x) / 8;
	}
	
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int start_offset = x1 % 8;
		int first_full_byte = x1 / 8;
		if (start_offset != 0) {
			first_full_byte++;
		}
		
		int end_offset = x2 % 8;
		int last_full_byte = x2 / 8;
		if (end_offset != 7) {
			last_full_byte--;
		}
		
		// Set full bytes
		for (int b = first_full_byte; b <= last_full_byte; b++) {
			screen[(width / 8) * y + b] = (byte) 0xFF;
		}
		
		byte start_mask = (byte) (0xFF >> start_offset);
		byte end_mask = (byte) ~(0xFF >> (end_offset + 1));
		
		// Set start and end of line
		if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
			byte mask = (byte) (start_mask & end_mask);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (start_offset != 0) {
				int byte_number = (width / 8) * y + first_full_byte - 1;
				screen[byte_number] |= start_mask;
			}
			if (end_offset != 7) {
				int byte_number = (width / 8) * y + last_full_byte + 1;
				screen[byte_number] |= end_mask;
			} 
		}
	}
	
	public static void printByte(byte b) {
		for (int i = 7; i >= 0; i--) {
			char c = ((b >> i) & 1) == 1 ? '1' : '_';
			System.out.print(c);
		}
	}
	
	public static void printScreen(byte[] screen, int width) {
		int height = screen.length * 8 / width;
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c+=8) {
				byte b = screen[computeByteNum(width, c, r)];
				printByte(b);
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		int width = 8 * 1;
		int height = 1;
		for (int r = 0; r < height; r++) {
			for (int c1 = 0; c1 < width; c1++) {
				for (int c2 = c1; c2 < width; c2++) {
					byte[] screen = new byte[width * height / 8];

					System.out.println("row: " + r + ": " + c1 + " -> " + c2);
					drawLine(screen, width, c1, c2, r);
					printScreen(screen, width);
					System.out.println("\n\n");
				}
			}
		}

	}

}
