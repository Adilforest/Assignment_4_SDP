package observer;

public class NewsAgency extends ObservableBase {
    public void addNews(String news) {
        notifyObservers(news);
    }
}