package com.li.pc.llibrary.developmentModel.strategy;

import org.xutils.common.util.LogUtil;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：11:42
 * function :策略接口-根据不同的事件来实现接口
 */

public class WalkStrategy implements Strategy {
    @Override
    public void travel() {
        LogUtil.i("walk");
    }
}
