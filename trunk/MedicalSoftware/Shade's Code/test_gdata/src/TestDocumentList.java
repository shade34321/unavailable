import com.google.gdata.client.*;
import com.google.gdata.client.docs.*;
import com.google.gdata.data.MediaContent;
import com.google.gdata.data.acl.*;
import com.google.gdata.data.docs.*;
import com.google.gdata.data.extensions.*;
import com.google.gdata.util.*;
import java.net.URL;

public class TestDocumentList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*try{
			DocsService service = new DocsService("Document List Demo");
			service.setUserCredentials("shade34321@gmail.com", "");
			
			URL documentListFeedUrl = new URL("http://docs.google.com/feeds/documents/private/full");
			
			DocumentListFeed feed = service.getFeed(documentListFeedUrl, DocumentListFeed.class);
			
			for(DocumentListEntry entry: feed.getEntries()){
				System.out.println(entry.getTitle().getPlainText());
			
			}
		}
		catch(Exception ex){
			System.err.println("Exception: " + ex.getMessage());
		}*/
		
		DocsService client = new DocsService("Unavailable-Medical Application-v1");

	}
}
