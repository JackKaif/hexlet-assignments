package exercise;

// BEGIN
public class ListThread extends Thread {
    SafetyList list;
    public ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add((int) (Math.random() * 1000));
        }
    }
}
// END
