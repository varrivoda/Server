package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		// будем подключаться к мнашему ерверу.
		// для этогосо стороны клиента нужно щнать две вещт:
		// ip-адрес сервера и порт

		// создадим новый Сокет с параметрами ip и port
		// и обернем его в блок try-catch-с-ресурсами
		
		try (
				Socket socket = new Socket("127.0.0.1", 8000);
				
				//ПОСЛЕ ТОГО, КАК СОЗДАЛИ СОКЕТ, НЕОБХОДИМО СОЗДАТЬ ВСЕ ТО ЖЕ САМОЕ,
				// ЧТО И В СЕРВЕРЕ, В КАЕСТВЕ ПОРТОВ(?)
				// СКОПИПАСТИМ ВСЕ ЭТО ДЕЛО, И ПОЛОЖИМ ТОЖЕ В РЕСУРСЫ.
				
				BufferedWriter writer = new BufferedWriter(
							new OutputStreamWriter(
											socket.getOutputStream()));
	
				BufferedReader reader= new BufferedReader(
							new InputStreamReader(
											socket.getInputStream()))		
		)
		{	
			//ЕСЛИ МЫ ЗАПУСКАЕМ ПРОГРАММУ БЕЗ ЗАПУЩЕННОГО СЕРВЕРА, 
			// ВЫЛЕТАЕТ ОШИБКА CONNETION REFUSED
			// СНАЧАЛА НАДО ЗАПУСТИТЬ СЕРВЕР
				// НА ДАННОМ ЭТАПЕ КЛИЕНТ НИЧЕГО НЕОТПРАВЛЯЕТ, 
				// ПОЭТОМУ НА СЕРВЕРЕ REQUEST = null
				// ТО ЕСТЬ,НЕ БЫЛО ЗАПРОСА
			// БУДЕМ ОТПРАВЛЯТЬ.
			// В СЛУЧАЕ КЛИЕНТА,ЖДАТЬ ПОООДКЛЮЧЕНИЯ НАМ НЕНАДО, МОЖЕМ СРАЗУ ОТПРАВЛЯТЬ
			
			writer.write("Vladivostok");	
			writer.newLine();
			writer.flush();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
