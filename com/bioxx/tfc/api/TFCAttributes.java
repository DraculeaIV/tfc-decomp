/*    */ package com.bioxx.tfc.api;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*    */ 
/*    */ 
/*    */ public class TFCAttributes
/*    */ {
/*  9 */   public static final UUID OVERBURDENED_UUID = UUID.fromString("772A6B8D-DA3E-4C1C-8813-96EA6097278D");
/* 10 */   public static final AttributeModifier OVERBURDENED = (new AttributeModifier(OVERBURDENED_UUID, "Overburdened speed penalty", -1.0D, 2)).func_111168_a(false);
/* 11 */   public static final UUID THIRSTY_UUID = UUID.fromString("772A6B8D-DA3E-4C1C-9999-96EA6097278D");
/* 12 */   public static final AttributeModifier THIRSTY = (new AttributeModifier(THIRSTY_UUID, "Thirsty speed penalty", -0.3D, 2)).func_111168_a(false);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\TFCAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */