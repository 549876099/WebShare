package com.share.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.share.domain.JsonObj;
import com.share.staticresource.StaticResource;
import com.share.util.JsonHandle;
import com.share.util.SocketUtil;

public class SocketIdentify implements Runnable{
	private Socket socket = null;
	
	public SocketIdentify(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
			try {
				InputStream in = socket.getInputStream();
				String jsonString = SocketUtil.readStrFromStream(in);
				JsonObj jsonObj = JsonHandle.handle(jsonString);
				Socket alreadyExitSocket = StaticResource.socketMap.get(jsonObj.getCode());
				
				if (alreadyExitSocket == null) {
					//开始注册
					new SocketRegist(socket, jsonObj.getCode());

					//测试代码
					System.out.println("注册成功！");

				}else {
					//确认是否为重连
					if (jsonObj.getAct().equals("recon")) {
						//先注销该Socke
						StaticResource.socketMap.remove(jsonObj.getCode());
						alreadyExitSocket.close();
						//开始注册
						new SocketRegist(socket, jsonObj.getCode());

						//测试代码
						System.out.println("断连注册成功！");

					} else {
						//测试代码
						System.out.println("非法Socket！");

						//验证码已存在
						socket.close();
						socket = null;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();

				//测试代码
				System.out.println("SocketIdentify");
			}
		}
	}