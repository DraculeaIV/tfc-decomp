/*    */ package com.bioxx.tfc;
/*    */ 
/*    */ import com.bioxx.tfc.ASM.Transform.TF_EntityLeashKnot;
/*    */ import com.bioxx.tfc.ASM.Transform.TF_EntityPlayer;
/*    */ import com.bioxx.tfc.ASM.Transform.TF_EntityPlayerMP;
/*    */ import com.bioxx.tfc.ASM.Transform.TF_EntityRenderer;
/*    */ import com.bioxx.tfc.ASM.Transform.TF_RenderGlobal;
/*    */ import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
/*    */ import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
/*    */ import java.io.File;
/*    */ import java.util.Map;
/*    */ 
/*    */ @TransformerExclusions({"com.bioxx.tfc.ASM"})
/*    */ public class TFCASMLoadingPlugin implements IFMLLoadingPlugin {
/*    */   public static boolean runtimeDeobf;
/*    */   public static File location;
/*    */   
/*    */   public String getAccessTransformerClass() {
/* 19 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getASMTransformerClass() {
/* 24 */     return new String[] { TF_EntityRenderer.class
/* 25 */         .getName(), TF_RenderGlobal.class
/* 26 */         .getName(), TF_EntityLeashKnot.class
/* 27 */         .getName(), TF_EntityPlayerMP.class
/* 28 */         .getName(), TF_EntityPlayer.class
/* 29 */         .getName() };
/*    */   }
/*    */ 
/*    */   
/*    */   public String getModContainerClass() {
/* 34 */     return TerraFirmaCraftCore.class.getName();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSetupClass() {
/* 39 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void injectData(Map<String, Object> data) {
/* 44 */     runtimeDeobf = ((Boolean)data.get("runtimeDeobfuscationEnabled")).booleanValue();
/* 45 */     location = (File)data.get("coremodLocation");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TFCASMLoadingPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */