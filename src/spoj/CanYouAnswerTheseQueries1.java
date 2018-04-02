package spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.max;

public class CanYouAnswerTheseQueries1 {

    private Reader in;
    private PrintWriter out;

    public CanYouAnswerTheseQueries1() throws Exception {
        in = new Reader();
        out = new PrintWriter(System.out, true);
    }

    private int[] x;

    private class IntervalTree {
        private IntervalTree left, right;
        private int start, end, prefix, suffix, ans, sum;

        IntervalTree() {}

        IntervalTree(int start, int end) {
            this.start = start;
            this.end = end;
            if (start != end) {
                int mid = (start + end) >> 1;
                left = new IntervalTree(start, mid);
                right = new IntervalTree(mid + 1, end);
                join(this, left, right);
            } else {
                prefix = suffix = ans = sum = x[start];
            }
        }

        private IntervalTree query(int a, int b) {
            if (a == start && b == end) return this;
            int mid = (start + end) >> 1;
            if (a > mid) return right.query(a, b);
            if (b <= mid) return left.query(a, b);
            IntervalTree result = new IntervalTree();
            join(result, left.query(a, mid), right.query(mid + 1, b));
            return result;
        }

        private void join(IntervalTree parent, IntervalTree leftChild, IntervalTree rightChild) {
            parent.sum = leftChild.sum + rightChild.suffix;
            parent.prefix = max(leftChild.sum + rightChild.prefix, leftChild.prefix);
            parent.suffix = max(rightChild.sum + leftChild.suffix, rightChild.suffix);
            parent.ans = max(max(leftChild.ans, rightChild.ans), leftChild.suffix + rightChild.prefix);
        }
    }

    public void solve() throws IOException {
        int n = in.nextInt();
        x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = in.nextInt();
        }
        IntervalTree tree = new IntervalTree(1, n);
        int q = in.nextInt();
        while (q-- > 0) {
            out.println(tree.query(in.nextInt(), in.nextInt()).ans);
        }
    }

    /** Faster input **/
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
        new CanYouAnswerTheseQueries1().solve();
    }

}
