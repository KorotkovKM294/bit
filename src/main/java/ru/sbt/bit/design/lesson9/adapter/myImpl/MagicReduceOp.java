package ru.sbt.bit.design.lesson9.adapter.myImpl;

import ru.sbt.bit.design.lesson9.adapter.lib.Operation;

/**
 * Adapter pattern.
 *
 * Created on 31.10.2016.
 *
 * @author Kirill M. Korotkov
 */
public class MagicReduceOp implements Operation {
    @Override
    public int op(int x, int y) {
        SuperMagicReduceOperation magic = new SuperMagicReduceOperation();
        return magic.doTheMagic(x, y, new ReduceSettings(ReduceMode.EXACT));
    }
}
