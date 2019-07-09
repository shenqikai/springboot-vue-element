 <template>

 <div>


  <div class="contanier">
    
  <div class="sidebar">
 
    



     
</div>
  <Dialog :showUpdateUserDialog="showUpdateUserDialog" >
            

        </Dialog >

<!-- <el-button type="button"  @click="dialogFormVisible = true"> 注册</el-button> -->
          <el-button icon="el-icon-download" type="success" @click="exportFile">导出</el-button>
        <el-upload
          style="display: inline"
          :show-file-list="false"
          :on-success="onSuccess"
          :on-error="onError"
          :before-upload="beforeUpload"
          action="http://localhost:8081/user/import">
          <el-button type="info" :disabled="!enabledUploadBtn" :icon="uploadBtnIcon">{{btnText}}</el-button>
        </el-upload>

   <!-- <el-form-item label="email" :label-width="formLabelWidth">
          <el-input v-model="form.email" autocomplete="off"></el-input>
        </el-form-item> -->

      <!-- <div>
          <el-button type="button"  @click="dialogFormVisible = true"> 注冊</el-button>
      </div> -->

   <el-input v-model="input" placeholder="请输入手机号" style="width:150px"></el-input>
   <el-button icon="el-icon-search" circle @click="findTel"></el-button>


    
    <el-table :data="userList"
              v-loading.body="listLoading"
              element-loading-text="loading"
               width="500px">
      <el-table-column   label="姓名" prop="username"></el-table-column>
      <el-table-column   label="密码" prop="password"></el-table-column>
      <el-table-column   label="email" prop="email"></el-table-column>
      <el-table-column   label="address" prop="address"></el-table-column>
      <el-table-column   label="tel" prop="tel"></el-table-column>

      <el-table-column label="Admin" align="center">
                      
        <template slot-scope="scope">
          <div style="margin-bottom: 10px">
            <el-button type="primary" size="mini" icon="el-icon-edit-outline"                   
                       @click.native.prevent="showUpdateUserDialog(scope.$index)">更新
            </el-button>
          </div>
          <div>
            <el-button type="danger" size="mini" icon="el-icon-delete"
                       
                       @click.native.prevent="removeUser(scope.$index)">删除
            </el-button>
          </div>
        </template>
      </el-table-column>

      
    </el-table>

  

    <el-dialog   :title="textMap[dialogStatus]"
           :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="username" :label-width="formLabelWidth">
          <el-input v-model="form.username" autocomplete="off" ></el-input>
        </el-form-item>
        <el-form-item label="password" :label-width="formLabelWidth">
          <el-input v-model="form.password" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="email" :label-width="formLabelWidth">
          <el-input v-model="form.email" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="address" :label-width="formLabelWidth">
          <el-input v-model="form.address" autocomplete="off"></el-input>
        </el-form-item>
            <el-form-item label="tel" :label-width="formLabelWidth">
          <el-input v-model="form.tel" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>

        <el-button type="primary"
                  :loading="btnLoading"
                   v-if="dialogStatus === 'add'"
                  @click="add">注册</el-button>

           <el-button type="primary"
                  v-else
                  :loading="btnLoading"
                  @click.native.prevent="update">更新
      </el-button>
      </div>
    </el-dialog>

      
<!-- 
    <el-dialog   :title="textMap[dialogStatus]"
           :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="username" :label-width="formLabelWidth">
          <el-input v-model="form.username" autocomplete="off" ></el-input>
        </el-form-item>
        <el-form-item label="password" :label-width="formLabelWidth">
          <el-input v-model="form.password" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="email" :label-width="formLabelWidth">
          <el-input v-model="form.email" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="address" :label-width="formLabelWidth">
          <el-input v-model="form.address" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>

        <el-button type="primary"
                  :loading="btnLoading"
                   v-if="dialogStatus === 'add'"
                  @click="add">注册</el-button>

           <el-button type="primary"
                  v-else
                  :loading="btnLoading"
                  @click.native.prevent="update">更新
      </el-button>
      </div>
    </el-dialog> -->
  </div>

     
 </div>
</template>
  <script>
import { list, addUser ,updateUser ,remove ,find} from "@/api/user";
import Dialog from '../components/Dialog'

export default {
  data() {
    return {
      uploadBtnIcon:'el-icon-upload2',
      enabledUploadBtn:true,
      btnText:'导入',
      dialogVisible: false,
      input: '',

       userList: [],
       dialogFormVisible: false,
       listLoading: false, // 数据加载等待动画
       dialogStatus: 'add',//默认add
       btnLoading: false,
       textMap: {
          update: '更新用户',
          add: '添加用户'
        },
        form: {
          id: "",
          username: '',
          password:'',
          email:'', 
          address:'',
          tel:'',
        },
        formLabelWidth: '120px'
    };
  },
  components: {
       'Dialog' :Dialog
  },
  //加载前
  created() {
    loading: false
    console.log("开始之前");
    // getUserList();async     await
  },
  mounted() {
    this.listLoading = false
    this.a();
    this.getUserListA();
    // this.response
    // console.log(response)
  },
  methods: {
    findTel(){

      let data={
        tel:this.input
      }
      // if(data==null){
      //   this.getUserListA();
      // }
      //拿到input的值
      console.log(data)
      find(data).then((response)=>{
       // this.$message.success('find success')
       // this.getUserListA();
        this.userList = response;
      })
    },
        //发送数据
    add(){
      // let data=this.form
      // console.log(data)、
      this.dialogStatus = 'add'
      btnLoading: true
      let data={
        username:this.form.username,
        password:this.form.password,
        email:this.form.email,
        address:this.form.address,
        tel:this.form.tel
      }
      this.readonly = false
      console.log(data)

      addUser(data).then(()=>{
          this.$message.success('add success')
          this.dialogFormVisible = false
          this.listLoading = true
          location.reload() ;
          this.getUserListA();
          console.log(data)
        })
     
     // this.getUserListA()
    },


   onSuccess(response,file,fileList) {
          this.enabledUploadBtn=true;
          this.uploadBtnIcon='el-icon-upload2';
          this.btnText='导入';
          console.log('122525255555555');
          console.log(response);
          if(response.code==201){
              this.$message.error(response.message);
           
          }
          //alert("数据导入成功！");
          //this.getUserListA();

        },
        onError(err, file, fileList) {
          this.enabledUploadBtn=true;
          this.uploadBtnIcon='el-icon-upload2'
          this.btnText='导入'
          alert("数据导入失败！请检查是否有重复数据,和网络连接状况！");
        },
        beforeUpload(file) {
          this.enabledUploadBtn=false;
          this.uploadBtnIcon='el-icon-loading';
          this.btnText='正在导入'
        },
        //导出
        exportFile() {
          window.open("http://localhost:8081/user/export", "_parent");
        },



    //发送数据
    ///undateUser

   update(){
        updateUser(this.form).then(()=>{
        this.$message.success('edit success')
        this.dialogFormVisible = false
        this.listLoading = true
        this.getUserListA()
        
        console.log(this.form,'==============')
      })

    },


    showUpdateUserDialog(index) {
      this.dialogStatus = 'update'
      this.dialogFormVisible=true
      btnLoading: true
      console.log('--=========  updateUser 开始===========')
      this.form.id = this.userList[index].id
      this.form.email = this.userList[index].email
      this.form.username = this.userList[index].username
      this.form.password = this.userList[index].password
      this.form.address = this.userList[index].address
      this.form.tel = this.userList[index].tel
       console.log(this.form)
       console.log('--=========  updateUser 拿到数据成功===========')
    },
    removeUser(index){
      this.$confirm('此操作将删除用户, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          const id = this.userList[index].id
          remove(id).then(() => {
          this.$message.success('delete success')
            this.getUserListA()
          })
          
        })
        
    },
    //遍历数据
    getUserListA() {
      this.listLoading = false
      console.log("111111");
      list()
        .then(response => {
          console.log(response);
          console.log(response.list,'========0000000=============');
          this.userList = response.list;
        })
        .catch(e => {
          console.log("3333333333", e);
        });
    },
    a() {
      console.log("222222");
     
    }
    
  }
};
</script>


<style>
   .contanier{
      width: 1000px;
       text-align:center;
       margin-left: 300px;
       
      Border:1px dashed  #DDDDDD;
      
   }

   .sidebar{
     width: 100px;
     margin-left: 20px;
     margin-bottom: 30px;
     Border:1px dashed  #DDDDDD;
   }
</style>
