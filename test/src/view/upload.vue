<template>
    <div style="margin: 20px">
      <div>
        <div style="display: flex;justify-content: center">
          <h2>玩家信息表格</h2>
        </div>
        <hr>
        <span>加入新召唤师：</span>
        <el-input v-model="userselect.nickname" placeholder="请输入昵称" style="width: 200px"></el-input>
        <el-select v-model="userselect.gamelevel" placeholder="请选择段位">
          <el-option
            v-for="item in userselects"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        <el-button type="primary" icon="el-icon-circle-plus" @click="addUser">添加</el-button>
        <el-button icon="el-icon-download" type="success" @click="exportFile">导出</el-button>
        <el-upload
          style="display: inline"
          :show-file-list="false"
          :on-success="onSuccess"
          :on-error="onError"
          :before-upload="beforeUpload"
          action="/user/import">
          <el-button type="info" :disabled="!enabledUploadBtn" :icon="uploadBtnIcon">{{btnText}}</el-button>
        </el-upload>
      </div>
      <hr>
      <div style="margin-top: 10px;">
        <el-table
          :data="userinfo"
          border
          style="width: 100%">
          <el-table-column
            prop="id"
            label="ID"
            width="180">
          </el-table-column>
          <el-table-column
            prop="nickname"
            label="昵称">
          </el-table-column>
          <el-table-column
            prop="gamelevel"
            label="段位">
            <template slot-scope="scope">
              <span v-if="scope.row.gamelevel">{{scope.row.gamelevel}}</span>
              <span v-else>暂无段位</span>
            </template>
          </el-table-column>
          <el-table-column
            prop="createdate"
            label="创建时间">
          </el-table-column>
          <el-table-column
            prop="enabled"
            label="是否可用">
            <template slot-scope="scope">
              <el-tag type="success" v-if="scope.row.enabled">是</el-tag>
              <el-tag type="info" v-else>否</el-tag>
            </template>
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="warning" @click="toUpdateUser(scope.row)">编辑</el-button>
              <el-button type="danger" @click="deleteUser(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-dialog
        title="修改"
        :visible.sync="dialogVisible"
        width="30%">
        <div>
          <table>
            <tr>
              <td>昵称</td>
              <td><el-input v-model="userupdate.nickupdate" placeholder="新昵称"></el-input></td>
            </tr>
            <tr>
              <td>段位</td>
              <td>
                <el-select v-model="userupdate.levelupdate" placeholder="请输入段位">
                  <el-option
                    v-for="item in userselects"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </td>
            </tr>
          </table>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="doUpdateUser">确 定</el-button>
        </span>
      </el-dialog>
    </div>
</template>

<script>
    export default {
      name: "User",
      mounted(){
        this.initUser();
      },
      data() {
        return {
          uploadBtnIcon:'el-icon-upload2',
          enabledUploadBtn:true,
          btnText:'导入',
          dialogVisible: false,
          userinfo: [],
          userselect:{
            nickname:'',
            gamelevel:''
          },
          userupdate:{
            id:'',
            nickupdate:'',
            levelupdate:'',
            createdate:'',
            enabled:''
          },
          userselects:[{
            value:'钻石',
            label:'钻石'
          },{
            value:'黄金',
            label:'黄金'
          },{
            value:'白银',
            label:'白银'
          },{
            value:'黑铁',
            label:'黑铁'
          },{
            value:null,
            label:'暂无段位'
          },]
        }
      },
      methods:{
        onSuccess(response,file,fileList) {
          this.enabledUploadBtn=true;
          this.uploadBtnIcon='el-icon-upload2';
          this.btnText='导入成功'
        },
        onError(err, file, fileList) {
          this.enabledUploadBtn=true;
          this.uploadBtnIcon='el-icon-upload2'
          this.btnText='导入'
        },
        beforeUpload(file) {
          this.enabledUploadBtn=false;
          this.uploadBtnIcon='el-icon-loading';
          this.btnText='正在导入'
        },
        exportFile() {
          window.open("/user/export", "_parent");
        },



        addUser() {
          this.postRequest("/user/",this.userselect).then(resp => {
            if (resp) {
              this.initUser();
              this.$message({
                type: 'success',
                message: '添加成功!'
              });
            }
          })
        },
        deleteUser(id) {
          this.$confirm('此操作将使玩家永远离开峡谷, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.deleteRequest("/user/"+id).then(resp => {
              if (resp) {
                this.$message({
                  type: 'success',
                  message: '删除成功!'
                });
                this.initUser();
              }
            })
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        },
        toUpdateUser(data) {          
          // alert(JSON.stringify(data));
          this.dialogVisible = true;
          this.userupdate.id=data.id;
          this.userupdate.nickupdate=data.nickname;
          this.userupdate.levelupdate=data.gamelevel;
          this.userupdate.createdate=data.createdate;
          this.userupdate.enabled=data.enabled

        },
        doUpdateUser() {
          this.dialogVisible = false;
          this.userselect.id=this.userupdate.id;
          this.userselect.nickname=this.userupdate.nickupdate;
          this.userselect.gamelevel=this.userupdate.levelupdate;
          this.userselect.createdate=this.userupdate.createdate;
          this.userselect.enabled=this.userupdate.enabled;
          alert(JSON.stringify(this.userselect))
          this.putRequest("/user/",this.userselect).then(resp => {
            if (resp) {
              this.initUser();
              this.$message({
                type: 'success',
                message: '修改成功!'
              });
            }else {
              this.$message({
                type: 'info',
                message: '未知错误，更新失败'
              });
            }
          })
        },
        initUser() {
          this.getRequest("/user/").then(resp => {
            if (resp) {
              this.userinfo=resp;
            }
          })
        }
      }
    }
</script>

<style scoped>

</style>
