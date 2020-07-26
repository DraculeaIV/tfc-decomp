/*     */ package com.bioxx.tfc.Handlers.Network;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemNBTPacket
/*     */   extends AbstractPacket
/*     */ {
/*  23 */   private NBTTagCompound tags = new NBTTagCompound();
/*  24 */   private List<String> tagNames = new LinkedList<String>();
/*  25 */   private List<String> removeNames = new LinkedList<String>();
/*     */ 
/*     */   
/*     */   public ItemNBTPacket(NBTTagCompound nbt) {
/*  29 */     this();
/*  30 */     this.tags = nbt;
/*     */   }
/*     */   public ItemNBTPacket() {}
/*     */   
/*     */   public ItemNBTPacket(NBTTagCompound nbt, List<String> acceptedTagNames) {
/*  35 */     this();
/*  36 */     this.tagNames = acceptedTagNames;
/*  37 */     for (String tagName : this.tagNames) {
/*  38 */       this.tags.func_74782_a(tagName, nbt.func_74781_a(tagName));
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemNBTPacket(NBTTagCompound nbt, List<String> acceptedTagNames, List<String> removeTagNames) {
/*  43 */     this();
/*  44 */     this.tagNames = acceptedTagNames;
/*  45 */     for (String tagName : this.tagNames)
/*  46 */       this.tags.func_74782_a(tagName, nbt.func_74781_a(tagName)); 
/*  47 */     this.removeNames = removeTagNames;
/*     */   }
/*     */   
/*     */   public ItemNBTPacket addAcceptedTag(String name) {
/*  51 */     if (!this.removeNames.contains(name) && !this.tagNames.contains(name))
/*  52 */       this.tagNames.add(name); 
/*  53 */     return this;
/*     */   }
/*     */   
/*     */   public ItemNBTPacket removeAcceptedTag(String name) {
/*  57 */     this.tagNames.remove(name);
/*  58 */     return this;
/*     */   }
/*     */   
/*     */   public ItemNBTPacket addRemoveTag(String name) {
/*  62 */     if (!this.removeNames.contains(name))
/*  63 */       this.removeNames.add(name); 
/*  64 */     return this;
/*     */   }
/*     */   
/*     */   public ItemNBTPacket removeRemoveTag(String name) {
/*  68 */     this.removeNames.remove(name);
/*  69 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/*  74 */     PacketBuffer pb = new PacketBuffer(buffer);
/*  75 */     NBTTagCompound tags = this.tags;
/*     */     
/*  77 */     for (String tagName : this.removeNames) {
/*  78 */       tags.func_82580_o(tagName);
/*     */     }
/*     */     try {
/*  81 */       pb.func_150786_a(tags);
/*     */       
/*  83 */       pb.writeInt(this.tagNames.size());
/*  84 */       for (String tagName : this.tagNames) {
/*  85 */         pb.func_150785_a(tagName);
/*     */       }
/*  87 */       pb.writeInt(this.removeNames.size());
/*  88 */       for (String tagName : this.removeNames)
/*  89 */         pb.func_150785_a(tagName); 
/*  90 */     } catch (Exception e) {
/*  91 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/*  97 */     PacketBuffer pb = new PacketBuffer(buffer);
/*     */     
/*     */     try {
/* 100 */       this.tags = pb.func_150793_b();
/*     */       
/* 102 */       int size = pb.readInt(); int i;
/* 103 */       for (i = 0; i < size; i++) {
/* 104 */         this.tagNames.add(pb.func_150789_c(256));
/*     */       }
/* 106 */       size = pb.readInt();
/* 107 */       for (i = 0; i < size; i++)
/* 108 */         this.removeNames.add(pb.func_150789_c(256)); 
/* 109 */     } catch (Exception e) {
/* 110 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleClientSide(EntityPlayer player) {
/* 118 */     ItemStack stack = player.field_71071_by.func_70448_g();
/*     */     
/* 120 */     if (stack != null) {
/*     */       NBTTagCompound stackNBT;
/* 122 */       if (stack.func_77942_o()) {
/*     */         
/* 124 */         stackNBT = stack.field_77990_d;
/*     */       }
/*     */       else {
/*     */         
/* 128 */         TerraFirmaCraft.LOG.error(TFC_Core.translate("error.error") + " " + stack.func_77977_a() + " " + 
/* 129 */             TFC_Core.translate("error.NBT") + " " + TFC_Core.translate("error.Contact"));
/* 130 */         stackNBT = new NBTTagCompound();
/*     */       } 
/*     */       
/* 133 */       for (String tagName : this.tagNames)
/* 134 */         stackNBT.func_74782_a(tagName, this.tags.func_74781_a(tagName)); 
/* 135 */       for (String tagName : this.removeNames)
/* 136 */         stackNBT.func_82580_o(tagName); 
/* 137 */       player.field_71071_by.func_70448_g().func_77982_d(stackNBT);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleServerSide(EntityPlayer player) {
/* 145 */     ItemStack stack = player.field_71071_by.func_70448_g();
/*     */     
/* 147 */     if (stack != null) {
/*     */       NBTTagCompound stackNBT;
/* 149 */       if (stack.func_77942_o()) {
/*     */         
/* 151 */         stackNBT = stack.field_77990_d;
/*     */       }
/*     */       else {
/*     */         
/* 155 */         TerraFirmaCraft.LOG.error(TFC_Core.translate("error.error") + " " + stack.func_77977_a() + " " + 
/* 156 */             TFC_Core.translate("error.NBT") + " " + TFC_Core.translate("error.Contact"));
/* 157 */         stackNBT = new NBTTagCompound();
/*     */       } 
/* 159 */       for (String tagName : this.tagNames)
/* 160 */         stackNBT.func_74782_a(tagName, this.tags.func_74781_a(tagName)); 
/* 161 */       for (String tagName : this.removeNames)
/* 162 */         stackNBT.func_82580_o(tagName); 
/* 163 */       player.field_71071_by.func_70448_g().func_77982_d(stackNBT);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Network\ItemNBTPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */