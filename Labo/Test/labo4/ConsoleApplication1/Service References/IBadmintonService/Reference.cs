﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace BadmintonClientConsole.IBadmintonService {
    using System.Runtime.Serialization;
    using System;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="SportClub", Namespace="http://schemas.datacontract.org/2004/07/BadmintonServiceLibrary")]
    [System.SerializableAttribute()]
    public partial class SportClub : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int IDField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string NaamField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private BadmintonClientConsole.IBadmintonService.Tornooi[] TornooienField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int ID {
            get {
                return this.IDField;
            }
            set {
                if ((this.IDField.Equals(value) != true)) {
                    this.IDField = value;
                    this.RaisePropertyChanged("ID");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Naam {
            get {
                return this.NaamField;
            }
            set {
                if ((object.ReferenceEquals(this.NaamField, value) != true)) {
                    this.NaamField = value;
                    this.RaisePropertyChanged("Naam");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public BadmintonClientConsole.IBadmintonService.Tornooi[] Tornooien {
            get {
                return this.TornooienField;
            }
            set {
                if ((object.ReferenceEquals(this.TornooienField, value) != true)) {
                    this.TornooienField = value;
                    this.RaisePropertyChanged("Tornooien");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Tornooi", Namespace="http://schemas.datacontract.org/2004/07/BadmintonServiceLibrary")]
    [System.SerializableAttribute()]
    public partial class Tornooi : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int IDField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string NaamField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int ID {
            get {
                return this.IDField;
            }
            set {
                if ((this.IDField.Equals(value) != true)) {
                    this.IDField = value;
                    this.RaisePropertyChanged("ID");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Naam {
            get {
                return this.NaamField;
            }
            set {
                if ((object.ReferenceEquals(this.NaamField, value) != true)) {
                    this.NaamField = value;
                    this.RaisePropertyChanged("Naam");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Lid", Namespace="http://schemas.datacontract.org/2004/07/BadmintonServiceLibrary")]
    [System.SerializableAttribute()]
    public partial class Lid : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int IDField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string NaamField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int ID {
            get {
                return this.IDField;
            }
            set {
                if ((this.IDField.Equals(value) != true)) {
                    this.IDField = value;
                    this.RaisePropertyChanged("ID");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Naam {
            get {
                return this.NaamField;
            }
            set {
                if ((object.ReferenceEquals(this.NaamField, value) != true)) {
                    this.NaamField = value;
                    this.RaisePropertyChanged("Naam");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="IBadmintonService.IBadmintonService")]
    public interface IBadmintonService {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IBadmintonService/GetSportClubs", ReplyAction="http://tempuri.org/IBadmintonService/GetSportClubsResponse")]
        BadmintonClientConsole.IBadmintonService.SportClub[] GetSportClubs();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IBadmintonService/GetSportClubs", ReplyAction="http://tempuri.org/IBadmintonService/GetSportClubsResponse")]
        System.Threading.Tasks.Task<BadmintonClientConsole.IBadmintonService.SportClub[]> GetSportClubsAsync();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IBadmintonService/GetLeden", ReplyAction="http://tempuri.org/IBadmintonService/GetLedenResponse")]
        BadmintonClientConsole.IBadmintonService.Lid[] GetLeden(int sportclubID);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IBadmintonService/GetLeden", ReplyAction="http://tempuri.org/IBadmintonService/GetLedenResponse")]
        System.Threading.Tasks.Task<BadmintonClientConsole.IBadmintonService.Lid[]> GetLedenAsync(int sportclubID);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface IBadmintonServiceChannel : BadmintonClientConsole.IBadmintonService.IBadmintonService, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class BadmintonServiceClient : System.ServiceModel.ClientBase<BadmintonClientConsole.IBadmintonService.IBadmintonService>, BadmintonClientConsole.IBadmintonService.IBadmintonService {
        
        public BadmintonServiceClient() {
        }
        
        public BadmintonServiceClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public BadmintonServiceClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public BadmintonServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public BadmintonServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public BadmintonClientConsole.IBadmintonService.SportClub[] GetSportClubs() {
            return base.Channel.GetSportClubs();
        }
        
        public System.Threading.Tasks.Task<BadmintonClientConsole.IBadmintonService.SportClub[]> GetSportClubsAsync() {
            return base.Channel.GetSportClubsAsync();
        }
        
        public BadmintonClientConsole.IBadmintonService.Lid[] GetLeden(int sportclubID) {
            return base.Channel.GetLeden(sportclubID);
        }
        
        public System.Threading.Tasks.Task<BadmintonClientConsole.IBadmintonService.Lid[]> GetLedenAsync(int sportclubID) {
            return base.Channel.GetLedenAsync(sportclubID);
        }
    }
}