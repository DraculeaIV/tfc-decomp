/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEDetailed;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.util.BitSet;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemBlueprint
/*     */   extends ItemTerra
/*     */ {
/*     */   public static final String SUFFIX = "BR:";
/*     */   public static final String TAG_COMPLETED = "Completed";
/*     */   public static final String TAG_ITEM_NAME = "ItemName";
/*     */   public static final String TAG_DATA = "Data";
/*     */   public static final String TAG_X_ANGLE = "xAngle";
/*     */   public static final String TAG_Y_ANGLE = "yAngle";
/*     */   public static final String TAG_Z_ANGLE = "zAngle";
/*     */   
/*     */   public ItemBlueprint() {
/*  36 */     func_77656_e(0);
/*  37 */     func_77627_a(true);
/*  38 */     func_77655_b("Blueprint");
/*  39 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*  40 */     setFolder("tools/");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77651_p() {
/*  46 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack stack, World world, EntityPlayer player) {
/*  52 */     MovingObjectPosition mo = Helper.getMouseOverObject((EntityLivingBase)player, world);
/*  53 */     int x = (int)player.field_70165_t;
/*  54 */     int y = (int)player.field_70163_u;
/*  55 */     int z = (int)player.field_70161_v;
/*  56 */     if (mo != null) {
/*  57 */       x = mo.field_72311_b; y = mo.field_72312_c; z = mo.field_72309_d;
/*     */     } 
/*     */     
/*  60 */     if (mo == null || world.func_147439_a(mo.field_72311_b, mo.field_72312_c, mo.field_72309_d) != TFCBlocks.detailed) {
/*  61 */       if (stack.func_77942_o() && stack.field_77990_d.func_74767_n("Completed")) {
/*  62 */         player.openGui(TerraFirmaCraft.instance, 34, player.field_70170_p, x, y, z);
/*     */       }
/*  64 */     } else if (!stack.func_77942_o() || !stack.field_77990_d.func_74767_n("Completed")) {
/*  65 */       player.openGui(TerraFirmaCraft.instance, 34, player.field_70170_p, mo.field_72311_b, mo.field_72312_c, mo.field_72309_d);
/*     */     } 
/*  67 */     return stack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  73 */     if (world.func_147439_a(x, y, z) != TFCBlocks.detailed) {
/*  74 */       return false;
/*     */     }
/*  76 */     if (!stack.func_77942_o() || !stack.field_77990_d.func_74767_n("Completed")) {
/*     */       
/*  78 */       TEDetailed te = (TEDetailed)world.func_147438_o(x, y, z);
/*     */       
/*  80 */       byte[] data = TEDetailed.toByteArray(te.data);
/*     */       
/*  82 */       NBTTagCompound nbt = new NBTTagCompound();
/*  83 */       nbt.func_74773_a("Data", data);
/*     */       
/*  85 */       stack.func_77982_d(nbt);
/*     */     }
/*  87 */     else if (stack.func_77942_o() && stack.field_77990_d.func_74767_n("Completed")) {
/*     */       
/*  89 */       int hasChisel = -1;
/*  90 */       int hasHammer = -1;
/*     */       
/*  92 */       if (!player.field_71075_bZ.field_75098_d) {
/*  93 */         for (int i = 0; i < 9; i++) {
/*  94 */           if (player.field_71071_by.field_70462_a[i] != null && player.field_71071_by.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemHammer)
/*  95 */             hasHammer = i; 
/*  96 */           if (player.field_71071_by.field_70462_a[i] != null && player.field_71071_by.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemChisel) {
/*  97 */             hasChisel = i;
/*     */           }
/*     */         } 
/* 100 */         if (hasChisel == -1 || hasHammer == -1) {
/*     */           
/* 102 */           if (!world.field_72995_K)
/*     */           {
/* 104 */             TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("gui.Blueprint.missingTool", new Object[0]));
/*     */           }
/* 106 */           return false;
/*     */         } 
/*     */       } 
/*     */       
/* 110 */       TEDetailed te = (TEDetailed)world.func_147438_o(x, y, z);
/* 111 */       BitSet blueprintData = TEDetailed.turnCube(stack.field_77990_d
/* 112 */           .func_74770_j("Data"), stack.field_77990_d
/* 113 */           .func_74762_e("xAngle"), stack.field_77990_d
/* 114 */           .func_74762_e("yAngle"), stack.field_77990_d
/* 115 */           .func_74762_e("zAngle"));
/*     */ 
/*     */       
/* 118 */       for (int c = 0; c < 512; c++) {
/* 119 */         if (te.data.get(c) && !blueprintData.get(c)) {
/*     */           
/* 121 */           te.data.clear(c);
/*     */           
/* 123 */           if (!player.field_71075_bZ.field_75098_d)
/*     */           {
/* 125 */             if (player.field_71071_by.field_70462_a[hasChisel] != null) {
/* 126 */               player.field_71071_by.field_70462_a[hasChisel].func_77972_a(1, (EntityLivingBase)player);
/*     */             } else {
/*     */               break;
/*     */             }  } 
/*     */         } 
/*     */       } 
/* 132 */       if (!world.field_72995_K) {
/*     */         
/* 134 */         world.func_147471_g(x, y, z);
/* 135 */         if (!player.field_71075_bZ.field_75098_d) {
/*     */           
/* 137 */           stack.field_77994_a--;
/*     */           
/* 139 */           if (stack.field_77994_a <= 0)
/* 140 */             stack = null; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_77653_i(ItemStack is) {
/* 150 */     if (is.func_77942_o() && is.field_77990_d.func_74764_b("Completed")) {
/* 151 */       return is.field_77990_d.func_74779_i("ItemName");
/*     */     }
/* 153 */     return TFC_Core.translate(func_77658_a());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 159 */     if (TFC_Core.showShiftInformation()) {
/*     */       
/* 161 */       arraylist.add(TFC_Core.translate("gui.Help"));
/* 162 */       arraylist.add(TFC_Core.translate("gui.Blueprint.Inst0"));
/* 163 */       if (is.func_77942_o() && !is.field_77990_d.func_74779_i("ItemName").isEmpty()) {
/* 164 */         arraylist.add(TFC_Core.translate("gui.Blueprint.Inst1"));
/*     */       }
/*     */     } else {
/*     */       
/* 168 */       arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlueprint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */