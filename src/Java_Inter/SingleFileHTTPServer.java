package Java_Inter;
/*
 * 
 * 单系统FTP服务器
 * author bzphaha
 * 
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleFileHTTPServer {
	private static final Logger logger = Logger.getLogger("SingleFileHTTPServer");
	
	private final byte[] content;
	private final byte[] header;
	private final int port;
	private final String encoding;
	
	public SingleFileHTTPServer(String data,String encoding,String mimeType,int port) throws UnsupportedEncodingException{
		this(data.getBytes(encoding),encoding,mimeType,port);
	}
	public SingleFileHTTPServer(byte[] data,String encoding,String mimeType,int port) {
		this.content = data;
		this.port = port;
		this.encoding = encoding;
		String header = "HTTP/1.0. 200 OK\r\n" + "Server: OnFile 2.0\r\n" + "Content-length : "+this.content.length+"\r\n"
						+ "Content-type" + mimeType +";charset = "+ encoding + "\r\n\r\n";
		this.header = header.getBytes(Charset.forName("US-ASCII"));
		
	}
	public void start(){
		ExecutorService pool = Executors.newFixedThreadPool(100);
		try(ServerSocket server = new ServerSocket(this.port)){
			logger.info("Accepting connections on port" + server.getLocalPort());
			logger.info("Data to be sent");
			logger.info(new String(this.content,encoding));
			while(true){
				try {
					Socket connection = server.accept();
					pool.submit(new HTTPHandler(connection));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	private class HTTPHandler implements Callable<Void>{
		private final Socket connection;
		HTTPHandler(Socket connection){
			this.connection = connection;
		}
		@Override
		public Void call() throws Exception {
			// TODO Auto-generated method stub
			try {
				OutputStream out = new BufferedOutputStream(connection.getOutputStream());
				InputStream in = new BufferedInputStream(connection.getInputStream());
				StringBuilder request = new StringBuilder(80);
				while(true){
					int c = in.read();
					if(c == '\r' || c == '\n' || c == -1){
						break;
					}
					request.append((char)c);
				}
				if(request.toString().indexOf("HTTP/") != -1){
					out.write(header);
				}
				out.write(content);
				out.flush();
			} catch (Exception e) {
				// TODO: handle exception
				logger.log(Level.WARNING,"Error writing to client",e);
			}
			finally{
				connection.close();
			}
			return null;
		}
	}
	public static void main(String[] args){
		String[] args1={"E:\\java-study\\abc.txt","8011","UTF-8"};
		int port;
		try {
			port = Integer.parseInt(args1[1]);
			if(port < 1 || port > 65535) port = 80;
			//System.out.println("执行这儿");
		} catch (Exception e) {
			// TODO: handle exception
			port = 80;
		}
		String encoding = "UTF-8";
		if(args1.length > 2)encoding = args1[2];
		try {
			Path path = Paths.get(args1[0]);
			System.out.println("path路径是"+path);
			byte[] data = Files.readAllBytes(path);
			//System.out.println("内容是"+data);
			String contentType = URLConnection.getFileNameMap().getContentTypeFor(args1[0]);
			//System.out.println("内容是"+contentType);
			SingleFileHTTPServer server = new SingleFileHTTPServer(data, encoding, contentType, port);
			System.out.println("执行");
			server.start();
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Usage: java SingFileHTTPServer filename port encoding");
		}
		catch(IOException ex){
			ex.printStackTrace();
			System.out.println("执行1");
			logger.severe(ex.getMessage());
		}
	}
}



