package com.share.service;

import com.share.main.Main;
import com.share.util.SocketUtil;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by GarryChung on 2017/4/30.
 */
public class SocketHeart extends Thread{
	private Socket socket = null;
	private String conCode = null;
	boolean isRun = true;

	public void setRun(boolean run) {
		isRun = run;
	}

	public SocketHeart(String conCode) {
		this.conCode = conCode;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("isRun：" + isRun);
			while (isRun)
				try {
					//重新赋值最新Socket
					socket = Main.socket;
					//发送心跳包
					SocketUtil.Send(socket,"{\"act\":\"heart\",\"code\":\""+conCode+"\"}");
					//测试代码
					//System.out.println("心跳成功！");
					Thread.sleep(8000);
				} catch (IOException e) {
					//e.printStackTrace();
					//System.out.println("异常，心跳关闭！");
					isRun = false;
				} catch (InterruptedException e) {
					//e.printStackTrace();
					//System.out.println("异常，心跳关闭！");
					isRun = false;
			}
		}
	}
}
