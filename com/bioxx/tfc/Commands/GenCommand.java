/*     */ package com.bioxx.tfc.Commands;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenCustomFruitTree;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenFissure;
/*     */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ public class GenCommand
/*     */   extends CommandBase
/*     */ {
/*     */   public String func_71517_b() {
/*  21 */     return "gen";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender sender, String[] params) {
/*  27 */     EntityPlayerMP player = func_71521_c(sender);
/*     */     
/*  29 */     if (!TFCOptions.enableDebugMode) {
/*     */       
/*  31 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Debug Mode Required"));
/*     */       
/*     */       return;
/*     */     } 
/*  35 */     if (params.length == 1) {
/*     */       
/*  37 */       if (params[0].equalsIgnoreCase("fruittree")) {
/*     */         
/*  39 */         TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Generating Fruit Tree"));
/*  40 */         WorldGenCustomFruitTree worldGenCustomFruitTree = new WorldGenCustomFruitTree(false, TFCBlocks.fruitTreeLeaves, 0);
/*     */         
/*  42 */         if (!worldGenCustomFruitTree.func_76484_a(sender.func_130014_f_(), (sender.func_130014_f_()).field_73012_v, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v)) {
/*  43 */           TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Generation Failed"));
/*     */         }
/*     */       } 
/*  46 */     } else if (params.length == 2) {
/*     */       
/*  48 */       if (params[0].equals("fissure")) {
/*     */         
/*  50 */         WorldGenFissure gen = null;
/*  51 */         if (params[1].equals("water")) {
/*     */           
/*  53 */           gen = new WorldGenFissure(TFCBlocks.freshWater);
/*  54 */           gen.checkStability = false;
/*  55 */           TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Generating Water"));
/*     */         }
/*  57 */         else if (params[1].equals("hotwater")) {
/*     */           
/*  59 */           gen = new WorldGenFissure(TFCBlocks.hotWater);
/*  60 */           gen.checkStability = false;
/*  61 */           TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Generating Hot Springs"));
/*     */         }
/*     */         else {
/*     */           
/*  65 */           gen = new WorldGenFissure(null);
/*  66 */           gen.checkStability = false;
/*  67 */           TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Generating Fissure"));
/*     */         } 
/*  69 */         gen.generate(sender.func_130014_f_(), (sender.func_130014_f_()).field_73012_v, (int)player.field_70165_t, (int)player.field_70163_u - 1, (int)player.field_70161_v);
/*     */       }
/*  71 */       else if (params[0].equalsIgnoreCase("tree")) {
/*     */         
/*  73 */         int i = getTree(params[1]);
/*     */         
/*  75 */         if (i != -1) {
/*     */           
/*  77 */           TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Generating Small " + params[1] + " Tree"));
/*  78 */           WorldGenerator treeGen = TFCBiome.getTreeGen(i, Boolean.valueOf(false));
/*  79 */           if (!treeGen.func_76484_a(sender.func_130014_f_(), (sender.func_130014_f_()).field_73012_v, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v)) {
/*  80 */             TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Generation Failed"));
/*     */           }
/*     */         } else {
/*  83 */           TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Invalid Tree"));
/*     */         } 
/*     */       } 
/*  86 */     } else if (params.length == 3 && params[0].equalsIgnoreCase("tree") && params[2].equalsIgnoreCase("big")) {
/*     */       
/*  88 */       int i = getTree(params[1]);
/*     */       
/*  90 */       if (i != -1) {
/*     */         
/*  92 */         TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Generating Big " + params[1] + " Tree"));
/*  93 */         WorldGenerator treeGen = TFCBiome.getTreeGen(i, Boolean.valueOf(true));
/*  94 */         if (!treeGen.func_76484_a(sender.func_130014_f_(), (sender.func_130014_f_()).field_73012_v, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v)) {
/*  95 */           TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Generation Failed"));
/*     */         }
/*     */       } else {
/*  98 */         TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Invalid Tree"));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/* 105 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTree(String tree) {
/* 110 */     if ("oak".equalsIgnoreCase(tree))
/* 111 */       return 0; 
/* 112 */     if ("aspen".equalsIgnoreCase(tree))
/* 113 */       return 1; 
/* 114 */     if ("birch".equalsIgnoreCase(tree))
/* 115 */       return 2; 
/* 116 */     if ("chestnut".equalsIgnoreCase(tree))
/* 117 */       return 3; 
/* 118 */     if ("douglasfir".equalsIgnoreCase(tree))
/* 119 */       return 4; 
/* 120 */     if ("hickory".equalsIgnoreCase(tree))
/* 121 */       return 5; 
/* 122 */     if ("maple".equalsIgnoreCase(tree))
/* 123 */       return 6; 
/* 124 */     if ("ash".equalsIgnoreCase(tree))
/* 125 */       return 7; 
/* 126 */     if ("pine".equalsIgnoreCase(tree))
/* 127 */       return 8; 
/* 128 */     if ("sequoia".equalsIgnoreCase(tree))
/* 129 */       return 9; 
/* 130 */     if ("spruce".equalsIgnoreCase(tree))
/* 131 */       return 10; 
/* 132 */     if ("sycamore".equalsIgnoreCase(tree))
/* 133 */       return 11; 
/* 134 */     if ("whitecedar".equalsIgnoreCase(tree))
/* 135 */       return 12; 
/* 136 */     if ("whiteelm".equalsIgnoreCase(tree))
/* 137 */       return 13; 
/* 138 */     if ("willow".equalsIgnoreCase(tree))
/* 139 */       return 14; 
/* 140 */     if ("kapok".equalsIgnoreCase(tree))
/* 141 */       return 15; 
/* 142 */     if ("acacia".equalsIgnoreCase(tree)) {
/* 143 */       return 16;
/*     */     }
/* 145 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\GenCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */