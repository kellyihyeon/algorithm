package com.github.kellyihyeon.section04linkedlist;

import java.util.Arrays;

/**
 * addr
 *  - 배열 상에서 몇 번지인지 의미
 *  - 연결 리스트에서 2번째 원소를 의미하는 게 아니라 해당 원소의 주소가 2번지!!
 */
public class LinkedListTest {
    private static final int MX = 1000005;
    private static int[] dat = new int[MX], pre = new int[MX], nxt = new int[MX];
    private static int unused = 1;

    public static void main(String[] args) {
        Arrays.fill(pre, -1);
        Arrays.fill(nxt, -1);
        insertTest();
        eraseTest();
    }

    public static void insert(int addr, int num) {
        // 1. 새로운 원소를 생성
        dat[unused] = num;
        // 2. 새 원소의 pre 값에 삽입할 위치의 주소를 대입
        pre[unused] = addr;
        // 3. 새 원소의 nxt 값에 삽입할 위치의 nxt 값을 대입
        int originNextAddress = nxt[addr];
        nxt[unused] = originNextAddress;
        // 4. 삽입할 위치의 nxt 값과 삽입할 위치의 다음 원소의 pre 값을 새 원소로 변경
        nxt[addr] = unused;
        if (originNextAddress != -1) {
            pre[originNextAddress] = unused;
        }
        // 5. unused 1 증가
        unused++;
    }

    public static void erase(int addr) {
        int preOfStandard = pre[addr];
        int nxtOfStandard = nxt[addr];

        nxt[preOfStandard] = nxtOfStandard;
        if (nxtOfStandard != -1) {
            pre[nxtOfStandard] = preOfStandard;
        }
    }

    public static void traverse() {
        int cur = nxt[0];
        while (cur != -1) {
            System.out.print(dat[cur] + " ");
            cur = nxt[cur];
        }
        System.out.println("\n");
    }

    public static void insertTest() {
        System.out.println("****** insert_test *****");
        insert(0, 10); // 10(address=1)
        traverse();
        insert(0, 30); // 30(address=2) 10
        traverse();
        insert(2, 40); // 30 40(address=3) 10
        traverse();
        insert(1, 20); // 30 40 10 20(address=4)
        traverse();
        insert(4, 70); // 30 40 10 20 70(address=5)
        traverse();
    }

    public static void eraseTest() {
        System.out.println("****** erase_test *****");
        erase(1); // 30 40 20 70
        traverse();
        erase(2); // 40 20 70
        traverse();
        erase(4); // 40 70
        traverse();
        erase(5); // 40
        traverse();
    }
}
