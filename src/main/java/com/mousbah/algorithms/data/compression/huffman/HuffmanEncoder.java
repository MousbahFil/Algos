/**
 *  Copyright Murex S.A.S., 2003-2018. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.mousbah.algorithms.data.compression.huffman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

import com.mousbah.algorithms.linkedlist.List;


public class HuffmanEncoder {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static List<String> encode(String text) {
        Map<Character, Integer> table = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            if (table.containsKey(text.charAt(i))) {
                table.put(text.charAt(i), table.get(i) + 1);
            } else {
                table.put(text.charAt(i), 1);
            }
        }

        PriorityQueue<AbstractHuffmanNode> priorityQueue = new PriorityQueue<>();
        Iterator<Map.Entry<Character, Integer>> iterator = table.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            priorityQueue.add(new LeafNode(entry.getValue(), entry.getKey()));
        }

    }

}
