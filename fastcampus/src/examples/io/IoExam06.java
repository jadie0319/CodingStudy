package examples.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoExam06 {

	public static void main(String[] args) {
		
		DataInputStream in = null;
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream("/tmp/data.bin"));
            out.writeBoolean(true);
            out.writeInt(1000);
            out.writeDouble(50.4);
            out.writeUTF("안녕하세요.");

            in = new DataInputStream(new FileInputStream("/tmp/data.bin"));
            boolean flag = in.readBoolean();
            int i = in.readInt();
            double d = in.readDouble();
            String str = in.readUTF();
            System.out.println(flag);
            System.out.println(i);
            System.out.println(d);
            System.out.println(str);

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                in.close();
            }catch(IOException ex){}
            try {
                out.close();
            }catch(IOException ex){}
        }

	}

}
