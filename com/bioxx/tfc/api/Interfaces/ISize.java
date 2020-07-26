package com.bioxx.tfc.api.Interfaces;

import com.bioxx.tfc.api.Enums.EnumItemReach;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import net.minecraft.item.ItemStack;

public interface ISize {
  EnumSize getSize(ItemStack paramItemStack);
  
  EnumWeight getWeight(ItemStack paramItemStack);
  
  EnumItemReach getReach(ItemStack paramItemStack);
  
  boolean canStack();
}


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Interfaces\ISize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */