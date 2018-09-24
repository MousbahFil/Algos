/**
 *  Copyright Murex S.A.S., 2003-2018. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.mousbah.algorithms.data.compression.huffman;

public class HuffmanNode extends AbstractHuffmanNode {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    private AbstractHuffmanNode leftNode;
    private AbstractHuffmanNode rightNode;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors
    //~ ----------------------------------------------------------------------------------------------------------------

    public HuffmanNode(AbstractHuffmanNode leftNode, AbstractHuffmanNode rightNode) {
        super(leftNode.getFrequency() + rightNode.getFrequency());
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public AbstractHuffmanNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(AbstractHuffmanNode leftNode) {
        this.leftNode = leftNode;
    }

    public AbstractHuffmanNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(AbstractHuffmanNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
