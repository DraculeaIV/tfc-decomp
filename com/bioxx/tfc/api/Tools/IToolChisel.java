package com.bioxx.tfc.api.Tools;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IToolChisel {
  boolean onUsed(World paramWorld, EntityPlayer paramEntityPlayer, int paramInt1, int paramInt2, int paramInt3, Block paramBlock, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3);
  
  boolean canChisel(EntityPlayer paramEntityPlayer, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Tools\IToolChisel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */