package com.tarena.elts.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Server {
   public void main(String[] args) throws IOException{
	   Server server=new Server();
	   server.start();
   }
   private void start() throws IOException{
	   Server server=new Server();
	   while(true){
		   Socket s=ss.accept();
	   }
   }
   private class Server extends Thread{
	   Socket s;
	   public Server(Socket s){
		   this.s=s;
	   }
	   
	   public void run(){
		   ObjectInputStream ois=
	   }
   }
}
