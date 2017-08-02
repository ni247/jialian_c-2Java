package cn.itcast.demo4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class Upload implements Runnable {
	private Socket socket;

	public Upload(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			//防止文件同名被覆盖,从新定义文件名字
			//规则:域名+毫秒值+6位随机数
			String fileName = "itcast" + System.currentTimeMillis()
					+ new Random().nextInt(999999) + ".jpg";
			//创建文件夹,文件
			File file = new File("D:" + File.separator + "upload"
					+ File.separator + fileName);
			if (!file.exists())
				file.getParentFile().mkdirs();

			InputStream in = socket.getInputStream();
			byte[] data = new byte[1024];
			BufferedInputStream bis = new BufferedInputStream(in);
			int len;
			FileOutputStream fos = new FileOutputStream(file);
			while ((len = bis.read(data)) != -1) {
				fos.write(data, 0, len);
			}

			OutputStream out = socket.getOutputStream();
			out.write("上传成功".getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
