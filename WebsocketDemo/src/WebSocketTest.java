
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @ServerEndpoint 娉ㄨВ鏄竴涓被灞傛鐨勬敞瑙ｏ紝瀹冪殑鍔熻兘涓昏鏄皢鐩墠鐨勭被瀹氫箟鎴愪竴涓獁ebsocket鏈嶅姟鍣ㄧ,
 * 娉ㄨВ鐨勫?灏嗚鐢ㄤ簬鐩戝惉鐢ㄦ埛杩炴帴鐨勭粓绔闂甎RL鍦板潃,瀹㈡埛绔彲浠ラ?杩囪繖涓猆RL鏉ヨ繛鎺ュ埌WebSocket鏈嶅姟鍣ㄧ
 */
@ServerEndpoint("/websocket")
public class WebSocketTest {
	//闈欐?鍙橀噺锛岀敤鏉ヨ褰曞綋鍓嶅湪绾胯繛鎺ユ暟銆傚簲璇ユ妸瀹冭璁℃垚绾跨▼瀹夊叏鐨勩?
	private static int onlineCount = 0;

	//concurrent鍖呯殑绾跨▼瀹夊叏Set锛岀敤鏉ュ瓨鏀炬瘡涓鎴风瀵瑰簲鐨凪yWebSocket瀵硅薄銆傝嫢瑕佸疄鐜版湇鍔＄涓庡崟涓?鎴风閫氫俊鐨勮瘽锛屽彲浠ヤ娇鐢∕ap鏉ュ瓨鏀撅紝鍏朵腑Key鍙互涓虹敤鎴锋爣璇?
	private static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<WebSocketTest>();

	//涓庢煇涓鎴风鐨勮繛鎺ヤ細璇濓紝闇?閫氳繃瀹冩潵缁欏鎴风鍙戦?鏁版嵁
	private Session session;

	/**
	 * 杩炴帴寤虹珛鎴愬姛璋冪敤鐨勬柟娉?
	 * @param session  鍙?鐨勫弬鏁般?session涓轰笌鏌愪釜瀹㈡埛绔殑杩炴帴浼氳瘽锛岄渶瑕侀?杩囧畠鏉ョ粰瀹㈡埛绔彂閫佹暟鎹?
	 */
	@OnOpen
	public void onOpen(Session session){
		this.session = session;
		webSocketSet.add(this);     //鍔犲叆set涓?
		addOnlineCount();           //鍦ㄧ嚎鏁板姞1
		System.out.println("鏈夋柊杩炴帴鍔犲叆锛佸綋鍓嶅湪绾夸汉鏁颁负" + getOnlineCount());
	}

	/**
	 * 杩炴帴鍏抽棴璋冪敤鐨勬柟娉?
	 */
	@OnClose
	public void onClose(){
		webSocketSet.remove(this);  //浠巗et涓垹闄?
		subOnlineCount();           //鍦ㄧ嚎鏁板噺1
		System.out.println("鏈変竴杩炴帴鍏抽棴锛佸綋鍓嶅湪绾夸汉鏁颁负" + getOnlineCount());
	}

	/**
	 * 鏀跺埌瀹㈡埛绔秷鎭悗璋冪敤鐨勬柟娉?
	 * @param message 瀹㈡埛绔彂閫佽繃鏉ョ殑娑堟伅
	 * @param session 鍙?鐨勫弬鏁?
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("鏉ヨ嚜瀹㈡埛绔殑娑堟伅:" + message);
		//缇ゅ彂娑堟伅
		for(WebSocketTest item: webSocketSet){
			try {
				item.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
	}

	/**
	 * 鍙戠敓閿欒鏃惰皟鐢?
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error){
		System.out.println("鍙戠敓閿欒");
		error.printStackTrace();
	}

	/**
	 * 杩欎釜鏂规硶涓庝笂闈㈠嚑涓柟娉曚笉涓?牱銆傛病鏈夌敤娉ㄨВ锛屾槸鏍规嵁鑷繁闇?娣诲姞鐨勬柟娉曘?
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException{
		this.session.getBasicRemote().sendText(message);
		//this.session.getAsyncRemote().sendText(message);
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketTest.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocketTest.onlineCount--;
	}
}
