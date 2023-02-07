package hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_17219 {
  static class HashTable {
    Data[] dataList;

    HashTable(int max) {
      dataList = new Data[max];
    }

    static class Data {
      String key;
      String value;

      Data(String key, String value) {
        this.key = key;
        this.value = value;
      }
    }

    public int getHash(String key) {
      int hash = 0;
      for (var i = 0; i < key.length(); i++) {
        hash = (hash + key.charAt(i) * (i + 1)) % dataList.length;
      }
      return hash;
    }

    public void push(String key, String value) {
      int hash = getHash(key);
      while (dataList[hash] != null && !dataList[hash].key.equals(key)) {
        hash = (hash + 1) % dataList.length;
      }
      dataList[hash] = new Data(key, value);
    }

    public String get(String key) {
      int hash = getHash(key);
      while (dataList[hash] != null && !dataList[hash].key.equals(key)) {
        hash = (hash + 1) % dataList.length;
      }
      return dataList[hash] != null ? dataList[hash].value : null;
    }
  }

  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
    StringBuilder sb = new StringBuilder();

    String str = br.readLine(); // 한줄씩 받기
    StringTokenizer st = new StringTokenizer(str); // " "를 기준으로 나눈기

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashTable hashTable = new HashTable(n);

    for (var i = 0; i < n; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      hashTable.push(st.nextToken(), st.nextToken());
    }
    for (var i = 0; i < m; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      sb.append(hashTable.get(st.nextToken())).append("\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    result();
  }
}
