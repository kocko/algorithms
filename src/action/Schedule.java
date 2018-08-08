package action;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.bitCount;
import static java.lang.Math.*;
import static java.util.Comparator.comparingInt;

public class Schedule implements Closeable {

    private Reader in = new Reader();
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() throws Exception {
        n = in.nextInt();
        events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            events.add(new Event(in.nextInt(), in.nextInt()));
        }
        events.sort(comparingInt(e -> e.start));
        recurse(0, 0, 0, 0);
        out.println(result);
    }
    
    private class Event {
        private int start, end;

        private Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    private int n, result;
    private List<Event> events;
    
    private void recurse(int idx, int elly, int kriss, int mask) {
        int attended = bitCount(mask), remaining = n - idx;
        if (idx == n) {
            result = max(result, attended);
        } else if (attended + remaining > result) {
            Event next = events.get(idx);
            if (next.start >= elly && next.start >= kriss) {
                recurse(idx + 1, next.end, next.end, mask | (1 << idx));
            }
            if (next.start >= elly) {
                recurse(idx + 1, next.end, kriss, mask | (1 << idx));
            }
            if (next.start >= kriss) {
                recurse(idx + 1, elly, next.end, mask | (1 << idx));
            }
            recurse(idx + 1, elly, kriss, mask);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    class Reader {
        final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
        public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
        }public Reader(String file_name) throws IOException{din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
        }public String readLine() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
        }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
        }private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
        }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
        }public void close() throws IOException{if(din==null) return;din.close();}
    }

    public static void main(String[] args) throws Exception {
        try (Schedule instance = new Schedule()) {
            instance.solve();
        }
    }
}
