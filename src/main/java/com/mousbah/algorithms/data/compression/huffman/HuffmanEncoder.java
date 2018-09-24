/**
 * Copyright Murex S.A.S., 2003-2018. All Rights Reserved.
 * <p>
 * This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 * express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
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

    public static void main(String[] args) {
        System.out.println(HuffmanEncoder.encode("ABAACDB"));
    }

    public static String encode(String text) {
        Map<Character, Integer> table = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (table.containsKey(character)) {
                table.put(character, table.get(character) + 1);
            } else {
                table.put(character, 1);
            }
        }

        System.out.println(table);

        PriorityQueue<AbstractHuffmanNode> priorityQueue = new PriorityQueue<>();
        Iterator<Map.Entry<Character, Integer>> iterator = table.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            priorityQueue.add(new LeafNode(entry.getValue(), entry.getKey()));
        }

        while (priorityQueue.size() > 1) {
            AbstractHuffmanNode rightNode = priorityQueue.poll();
            AbstractHuffmanNode leftNode = priorityQueue.poll();
            priorityQueue.add(new HuffmanNode(leftNode, rightNode));
        }

        Map<Character, String> codeTable = createHuffmanCodeTable((HuffmanNode) priorityQueue.poll());
        System.out.println(String.format("The code table is '%s':", codeTable));

        StringBuilder sb = new StringBuilder();
        for (char character : text.toCharArray()) {
            sb.append(codeTable.get(character));
        }
        return sb.toString();
    }

    private static Map<Character, String> createHuffmanCodeTable(HuffmanNode node) {
        Map<Character, String> result = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        createHuffmanCodeTable(node, stringBuilder, result);
        return result;
    }

    private static void createHuffmanCodeTable(AbstractHuffmanNode node, StringBuilder stringBuilder, Map<Character, String> map) {
        if (node.isLeaf()) {
            LeafNode leafNode = (LeafNode) node;
            map.put(leafNode.getCharacter(), stringBuilder.toString());
            return;
        } else {
            HuffmanNode huffmanNode = (HuffmanNode) node;
            stringBuilder.append("0");
            createHuffmanCodeTable(huffmanNode.getLeftNode(), stringBuilder, map);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("1");
            createHuffmanCodeTable(huffmanNode.getRightNode(), stringBuilder, map);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

}
