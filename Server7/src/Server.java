import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		//первая версия будет просто ждать подключение
		
		// создадим серверСокет
		// при создании серверСокета нужнол указать только пор, который будет слушать сервер
		ServerSocket server = new ServerSocket(8000);
		// надо добавитьв блок try-catch или throws
		
		System.out.println("Server started");
		
//		server.accept();

//		System.out.println("Client connected");
		
		// пробуем подключиться через telnet , успешно
		
			// теперь напишем автоответчик
			// нужно создать подключение socket-socket
			// (мы его уже создали, но надо сохранить в переменную 
			Socket socket = server.accept();
			System.out.println("Client connected");
			
			// для общения через сокеты у класса Socket существует 2метода:
			// getInputSteram() и getOutputSteram()
			// нам нужен второй
			// который возвращает экхемпляр класса OutputStream
			OutputStream stream = socket.getOutputStream();
				
				// output stream сам по себе умеет писатль только байты,
				// а именно - по одному, либо массив байт.
				
				// поэтому мы сделаем OutputStreamWriter()
				OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
				// т.е. сначала мы созддали просто поток,а потом обернули другим потоком,
				// который умеет чуть больше, например записывать строку.
				
					//но есть еще один класс, кототый уммеет еще больше - 		
					BufferedWriter writer0 = new BufferedWriter(streamWriter);
					// и вот в таком виде мы уже будем использовать writer
			
//				OutputStream outputStream = socket.getOutputStream();
//					OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
//						BufferedWriter writer = new BufferedWriter(outputStreamWriter);
		
						
			//можно обойтисьбез создания промежуточных переменных, 
			// создав обертку на обертку:
			BufferedWriter writer = new BufferedWriter(
							new OutputStreamWriter(
											socket.getOutputStream()));
			
			//наконец-томы может написать ответ клиенту:
			writer.write("Hello from server");
			//но поскольку это буферизованый writer, то мыдолжнывыполить коману flush()		
			writer.flush();
					
					
	}

}
