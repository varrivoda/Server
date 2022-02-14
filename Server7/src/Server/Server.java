package Server;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		//первая версия будет просто ждать подключение
		
		// создадим серверСокет
		// при создании серверСокета нужнол указать только пор, который будет слушать сервер
//*		ServerSocket server = new ServerSocket(8000);
		// СерверСеектможети е создатбся, например,по приине занятости порта.
		// поэтому надо надо добавитьв блок try-catch или указать, что класс throws IOException
		
		
//*		System.out.println("Server started");
		
		// Однакото,ято мы создали СерверСокет, еще н чего не згачит. 
		// Мы просто сообщили программе, что нужно "ждать в 8000-й квартире"
		// но тудапока никто не пришел. 
		
			//чтобы "встретить гостя",нужно выполнить команду 
		
			//			server.accept();
		
			// которая возвращает -тоже- сокет (другой), который используется непосрелственно для общения.
		
			// эта команда работает долго. Она ожидает, пока клиент не подключится.
		
			//			System.out.println("Client connected"); // вывод после выполнения werver.accept();
		
			// пробуем подключиться через telnet , успешно
		
		
				// ****
				// теперь напишем автоответчик.
		
				// нужно создать подключение socket-socket
				// (мы его уже создали, но надо не просто вызвать, а сохранить сокет в переменную 
//*				Socket socket = server.accept();
//*				System.out.println("Client connected");
				
				// для общения через сокеты у класса Socket существует 2 метода:
				// getInputSteram() и getOutputSteram()
				// нам нужен второй
				// который возвращает экхемпляр класса OutputStream
//*				OutputStream stream = socket.getOutputStream();
					
					// output stream сам по себе умеет писатль только байты,
					// а именно - по одному, либо массив байт.
					
					// поэтому мы сделаем OutputStreamWriter()
//*					OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
					// т.е. сначала мы созддали просто поток,а потом обернули другим потоком,
					// который умеет чуть больше, например записывать строку.
					
						//но есть еще один класс, кототый уммеет еще больше - 		
//*						BufferedWriter writer0 = new BufferedWriter(streamWriter);
						// и вот в таком виде мы уже будем использовать writer
			
//				OutputStream outputStream = socket.getOutputStream();
//					OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
//						BufferedWriter writer = new BufferedWriter(outputStreamWriter);
		
						
			//можно обойтисьбез создания промежуточных переменных, 
			// создав обертку на обертку:
//*			BufferedWriter writer = new BufferedWriter(
//*							new OutputStreamWriter(
//*											socket.getOutputStream()));
			
			//наконец-томы может написать ответ клиенту:
//*			writer.write("HTTP/1.1 200 OK");
			//но поскольку это буферизованый writer, то мы должны выполить команду flush()
			// если этого несделать,сообщерие будет отправлено:
			//		1) когда будет достигнут максимальный размер буфера
			// 		2) когда writer закроется.
			
				//но перед flush - команду newLine();
//*			writer.newLine();
//*			writer.flush();
			
			// после этогоне  забыть всё закрыть.
			// в первуюочередь,закрыть writer
			// затем Сокет
			//ну и серверный сокет бы тоже не помешало
			
//*			writer.close();
//*			socket.close();
//*			server.close();
			
			// если нчего не закрыть, клиент будет висеть и ждать, чтопридет еще что-то.
			
//но в таком виде bo браузера нащ серыер работатьне будет,
//*** задание
//сделать так, чтобы можнобыло прочитать через браузер
// чтобы это произошлоЮ, нужно просто вместо "hello from server"
// отправить строку кода состояния 	HTTP ответа.
			
					
					// итак, автоответчик работает, можно былобыдти дальше,но....
					// ручные закрытия ресурсовэто неочень хорошо,
					// сделать бы через try (с ресурсами)
					
					// начиная с java 7 можно использовать екн-catch с ресурсами. 
					// дело в том, что необходтмость использования try часто сопряжена с необходимостьюзакрытия ресурсов, 
					// поэтому после ключевого слова try в скобкахмф можеи укащать ресурсы
					// в которыз послевыполнеия блока будет автоматически вызван метод close()
					// (правда, для этого вызываемые ресурсы долны реализовывать интерфейс Closeable{} )
					
			// в нашем случае это будет ServerSocket, метод accept() и создание порта (?)
			
			// однако в одном блоке это сделать не получится, 
			// т к созданbе порта (?)требует отдельного блока try-catch
			// придется вкладыывать два блока try. 
			// catch (){} при этом можетбыть общий.
				// кстатиЮ ака наим обраюботать возможный IOException?
				// вывести код,или printStackTrace может не подоти нам.
				// поэтому мы просто пробросим RutnimeException()
				// в этом случае не нужно писать throws в объявлении класса,
				// поскольку RuntimeExcption - не проверяемое исключение
		
//***		try(ServerSocket server = new ServerSocket(8001))
//***			{		
//***			System.out.println("Server started");
//***		
//***			try(
//***				Socket socket = server.accept();
//***				BufferedWriter writer = new BufferedWriter(
//***							new OutputStreamWriter(
//***											socket.getOutputStream()));
//***
//***				){
//***					System.out.println("Client connected \n");		
//***					
//***					writer.write("HTTP/1.1 200 OK");
//***					writer.newLine();
//***					writer.write("Hello from server!");
//***					writer.flush();
						
//**				 теперь можно убирать остальные закрытия 
//**				writer.close();
//**				socket.close();
	
//*					на данном этапе закрытие ServerSocket можем убрать		
//*					server.close(); 
				
				
							// теперь создадим BufferedReader
							// чтобыможно было не только отправлять
							// но и читать, что присылает клиент.
							// можно разместть его в ресурсах нашего второго вложенного try
							// но для непрерывности этого повествования в комментариях
							// сделаем для негоотдельный блок try_с_ресурсами
			
							// синтаксис классов аналогичен:
							// на основе getInputStream() делаем InputStreamReader 
							// а на основе его 

//					try(
//							BufferedReader reader= new BufferedReader(
//										new InputStreamReader(
//														socket.getInputStream()))		)
							
							// правда,есть ВОПРОС: 
							// СНАЧАЛА СЕРВЕР ДОЛЖЕН ОТВЕТИТЬ,ИЛИ ПРОЧИТАТЬ?
							
							//очевидно, что сначала прочитать,
							// а значит, нам нужно поменять порядок,
							// заодно поместим все вложенные блоки try в один
					
		try(ServerSocket server = new ServerSocket(8000))
		{		
			System.out.println("Server started");
		
			// ****бесконечный цикл
			while(true) {
				try(
					Socket socket = server.accept();
					BufferedWriter writer = new BufferedWriter(
								new OutputStreamWriter(
												socket.getOutputStream()));
	
					BufferedReader reader= new BufferedReader(
								new InputStreamReader(
												socket.getInputStream()))		)
	
					{
						String request = reader.readLine();
						
						writer.write("HTTP/1.1 200 OK");
						writer.newLine();
//						writer.write("Hello from server! \n" 
//									+ "Request contains "
//									+request.length()
//									+" symbols");
						System.out.println("Request: "+request);
						writer.flush();				
					
						// ПОЗДРАВЛЕМ. СЕРВЕР НАПИСАН.НАДО ПИСАТЬ КЛИЕНТ
						// НО ПРЕЖДЕ ЕЩЕ ОДНА ЗАДАЧА:
						// ПОПРОБУЕМ ОБРАТИТЬСЯ ИЗ БРАУЗЕРА
						// ВЫВЕДЯ В КОНСОЛЬ ЧИСЛО СИМВОЛОВ
						// терминал java покажет число 14
							// внимание вопрос! 
							//какие именно 14 символов пришли в запросе?
							// (просто надо вывести запрос на экран :) ) 
							//ответ - 'GET / HTTP/1.1"
								// однако если в браузеремы запросим какой-то адрес на сайте
								// например 127.0.0.1:8001/index.html
								// ответ будет "GET /index.html HTTP/1.1"
								// и будет содержать в себе уже 24 символа :) 
							
							// ЭТО - ТИПИЧНЫЙ GET-запрос.
							
						
						// ТАКЖЕ ПЕРЕД НАПИСАНИЕМ КЛИЕНТЬА НУЖНО СДЕЛАТЬ СЕРВЕР "МНОГОРАЗОВЫМ"
						// Т Е ОРГАНИЗОВАТЬ ВЕЧНЫЙ ЦИКЛ
						// НО ГДЕ ИМЕННО? ВОПРОС.
							// конечно ServerSocket содавать каждый раз не нужно.
							// поэтопу while(true) напишем перед вложенным блоком try 
							//****
					}catch(IOException e) {
						//e.printStackTrace();
						throw new RuntimeException(e);
					} // end try-catch #2
			} 	//end while(true)
			
			// ЕЩЕ ВОПРОСИК - ПОЧЕМУ БРАУЗЕР ОБРАЩАЕТСЯ К FAVICON?
			// ЭТО ОСОБЕННОСТЬ БРАУЗЕРА CHROME, ЭТОЗАПРОС МОЖНО ОТКЛЮЧИТЬ.
			
						//СОЗДАДИМ НОВЫЙ МОЖУЛЬ - КЛИЕНТ.
			
			
			
			
			
			
			
				// во втором, вложенном блоке try МОЖНО БЫЛО БЫ не писать catch
				// т.к. он у нас уже есть.
					// НО
					// ЕСЛИ ОШИБКА ВЫСКОЧИТ ВО ВЛОЖЕННОМ TRY, СЕРВЕР ОСТАНОВИТСЯ.
					// ПОЭТОМУ ЛОВИТЬ ИСКЛЮЧЕНИЕ НУЖНО ТАКЖЕ И СРАЗУПОСЛЕ НЕГО.
		}catch(IOException e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}			
					
			
					
					
	}

}
