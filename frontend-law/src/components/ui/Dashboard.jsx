/*
  This example requires some changes to your config:
  
  ```
  // tailwind.config.js
  module.exports = {
    // ...
    plugins: [
      // ...
      require('@tailwindcss/forms'),
    ],
  }
  ```
*/
import { Fragment, useState } from 'react'
import { Dialog, Disclosure, Menu, Transition } from '@headlessui/react'
import { XMarkIcon } from '@heroicons/react/24/outline'
import { ChevronDownIcon, FunnelIcon, MinusIcon, PlusIcon, Squares2X2Icon } from '@heroicons/react/20/solid'
import { Area, AreaChart, Bar, BarChart, CartesianGrid, Cell, Legend, Pie, PieChart, ResponsiveContainer, Tooltip, XAxis, YAxis } from 'recharts'
import logo from '../../assets/logo.png'

const sortOptions = [
    { name: 'Most Popular', href: '#', current: true },
    { name: 'Best Rating', href: '#', current: false },
    { name: 'Newest', href: '#', current: false },
    { name: 'Price: Low to High', href: '#', current: false },
    { name: 'Price: High to Low', href: '#', current: false },
]
const subCategories = [
    { name: 'dashboard', href: '#' },
    { name: 'documentacion', href: '#' },
    { name: 'agenda', href: '#' },
    { name: 'clientes', href: '#' },
    { name: 'subCategories5', href: '#' },
]
const subMenus = [
    {
        id: 'color',
        name: 'Color',
        options: [
            { value: 'white', label: 'White', checked: false },
            { value: 'beige', label: 'Beige', checked: false },
            { value: 'blue', label: 'Blue', checked: true },
            { value: 'brown', label: 'Brown', checked: false },
            { value: 'green', label: 'Green', checked: false },
            { value: 'purple', label: 'Purple', checked: false },
        ],
    },
    {
        id: 'category',
        name: 'Category',
        options: [
            { value: 'new-arrivals', label: 'New Arrivals', checked: false },
            { value: 'sale', label: 'Sale', checked: false },
            { value: 'travel', label: 'Travel', checked: true },
            { value: 'organization', label: 'Organization', checked: false },
            { value: 'accessories', label: 'Accessories', checked: false },
        ],
    },
    {
        id: 'size',
        name: 'Size',
        options: [
            { value: '2l', label: '2L', checked: false },
            { value: '6l', label: '6L', checked: false },
            { value: '12l', label: '12L', checked: false },
            { value: '18l', label: '18L', checked: false },
            { value: '20l', label: '20L', checked: false },
            { value: '40l', label: '40L', checked: true },
        ],
    },
]

const stats = [
    { id: 1, titulo: 'Weekly', valor: '714k', icono: 'https://minimal-kit-react.vercel.app/assets/icons/glass/ic_glass_bag.png' },
    { id: 2, titulo: 'New Users', valor: '1.35m', icono: 'https://minimal-kit-react.vercel.app/assets/icons/glass/ic_glass_users.png' },
    { id: 3, titulo: 'Item Orders', valor: '1.72m', icono: 'https://minimal-kit-react.vercel.app/assets/icons/glass/ic_glass_buy.png' },
    { id: 4, titulo: 'Bug Reports', valor: '234', icono: 'https://minimal-kit-react.vercel.app/assets/icons/glass/ic_glass_message.png' }
]

const data = [
    {name: "María", age: 10, weight: 60},
    {name: 'Karina', age: 25, weight: 70},
    {name: 'Susana', age: 15, weight: 65},
    {name: 'Pedro', age: 35, weight: 85},
    {name: 'Felipe', age: 12, weight: 48},
    {name: 'Laura', age: 30, weight: 69},
    {name: 'Adrián', age: 15, weight: 78},
]
const dataPay = [
    { name: "Group A", value: 2400 },
    { name: 'Group B', value: 4567 },
    { name: 'Group C', value: 1398 },
    { name: 'Group D', value: 9800 },
    { name: 'Group E', value: 3908 },
    { name: 'Group F', value: 4800 },
]
const COLORS = ['#ce93d8', '#5c6bc0', '#b39ddb', '#4dd0e1', '#f48fb1', '#d500f9']

function classNames(...classes) {
    return classes.filter(Boolean).join(' ')
}

export default function Dashboard() {
    const [mobileFiltersOpen, setMobileFiltersOpen] = useState(false)

    return (
        <div className="bg-white">
            <div>
                {/* Mobile filter dialog */}
                <Transition.Root show={mobileFiltersOpen} as={Fragment}>
                    <Dialog as="div" className="relative z-40 lg:hidden" onClose={setMobileFiltersOpen}>
                        <Transition.Child
                            as={Fragment}
                            enter="transition-opacity ease-linear duration-300"
                            enterFrom="opacity-0"
                            enterTo="opacity-100"
                            leave="transition-opacity ease-linear duration-300"
                            leaveFrom="opacity-100"
                            leaveTo="opacity-0"
                        >
                        <div className="fixed inset-0 bg-black bg-opacity-25" />
                        </Transition.Child>

                        <div className="fixed inset-0 z-40 flex">
                            <Transition.Child
                                as={Fragment}
                                enter="transition ease-in-out duration-300 transform"
                                enterFrom="translate-x-full"
                                enterTo="translate-x-0"
                                leave="transition ease-in-out duration-300 transform"
                                leaveFrom="translate-x-0"
                                leaveTo="translate-x-full"
                            >
                                <Dialog.Panel className="relative ml-auto flex h-full w-full max-w-xs flex-col overflow-y-auto bg-white py-4 pb-12 shadow-xl">
                                    <div className="flex items-center justify-between px-4">
                                        <h2 className="text-lg font-medium text-gray-900">Diego</h2>
                                        <button
                                            type="button"
                                            className="-mr-2 flex h-10 w-10 items-center justify-center rounded-md bg-white p-2 text-gray-400"
                                            onClick={() => setMobileFiltersOpen(false)}
                                        >
                                            <span className="sr-only">Close menu</span>
                                            <XMarkIcon className="h-6 w-6" aria-hidden="true" />
                                        </button>
                                    </div>

                                    {/* Filters */}
                                    <form className="mt-4 border-t border-gray-200">
                                        <h3 className="sr-only">Categories</h3>
                                        <ul role="list" className="px-2 py-3 font-medium text-gray-900">
                                            {subCategories.map((category) => (
                                                <li key={category.name}>
                                                    <a href={category.href} className="block px-2 py-3">
                                                        {category.name}
                                                    </a>
                                                </li>
                                            ))}
                                        </ul>

                                        {subMenus.map((section) => (
                                            <Disclosure as="div" key={section.id} className="border-t border-gray-200 px-4 py-6">
                                                {({ open }) => (
                                                    <>
                                                        <h3 className="-mx-2 -my-3 flow-root">
                                                            <Disclosure.Button className="flex w-full items-center justify-between bg-white px-2 py-3 text-gray-400 hover:text-gray-500">
                                                                <span className="font-medium text-gray-900">{section.name}</span>
                                                                <span className="ml-6 flex items-center">
                                                                    {open ? (
                                                                        <MinusIcon className="h-5 w-5" aria-hidden="true" />
                                                                    ) : (
                                                                        <PlusIcon className="h-5 w-5" aria-hidden="true" />
                                                                    )}
                                                                </span>
                                                            </Disclosure.Button>
                                                        </h3>
                                                        <Disclosure.Panel className="pt-6">
                                                            <div className="space-y-6">
                                                                {section.options.map((option, optionIdx) => (
                                                                    <div key={option.value} className="flex items-center">
                                                                        <input
                                                                            id={`filter-mobile-${section.id}-${optionIdx}`}
                                                                            name={`${section.id}[]`}
                                                                            defaultValue={option.value}
                                                                            type="checkbox"
                                                                            defaultChecked={option.checked}
                                                                            className="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500"
                                                                        />
                                                                        <label
                                                                            htmlFor={`filter-mobile-${section.id}-${optionIdx}`}
                                                                            className="ml-3 min-w-0 flex-1 text-gray-500"
                                                                        >
                                                                            {option.label}
                                                                        </label>
                                                                    </div>
                                                                ))}
                                                            </div>
                                                        </Disclosure.Panel>
                                                    </>
                                                )}
                                            </Disclosure>
                                        ))}
                                    </form>
                                </Dialog.Panel>
                            </Transition.Child>
                        </div>
                    </Dialog>
                </Transition.Root>

                <main className="bg-slate-800 mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
                    <div className="rounded-b-3xl border-b-2 border-[#FFFFFF] bg-[#100C18] mx-auto flex max-w-7xl items-center justify-between p-6 lg:px-8" aria-label="Global">

                        <div className="flex lg:flex-1">
                            <a href="#" className="-m-1.5 p-1.5">
                                <span className="sr-only">Dame tu Mano</span>
                                <img className="h-10 w-auto" src={logo} alt="" />
                            </a>
                        </div>

                        <div className="flex items-center">

                            <Menu as="div" className="relative inline-block text-left">
                                <div>
                                    <Menu.Button className="group inline-flex justify-center text-sm font-medium text-white hover:text-[#E37B3A]">
                                        Sort
                                        <ChevronDownIcon
                                            className="-mr-1 ml-1 h-5 w-5 flex-shrink-0 text-white group-hover:text-[#E37B3A]"
                                            aria-hidden="true"
                                        />
                                    </Menu.Button>
                                </div>

                                <Transition
                                    as={Fragment}
                                    enter="transition ease-out duration-100"
                                    enterFrom="transform opacity-0 scale-95"
                                    enterTo="transform opacity-100 scale-100"
                                    leave="transition ease-in duration-75"
                                    leaveFrom="transform opacity-100 scale-100"
                                    leaveTo="transform opacity-0 scale-95"
                                >
                                    <Menu.Items className="absolute right-0 z-10 mt-2 w-40 origin-top-right rounded-md bg-white shadow-2xl ring-1 ring-black ring-opacity-5 focus:outline-none">
                                        <div className="py-1">
                                            {sortOptions.map((option) => (
                                                <Menu.Item key={option.name}>
                                                    {({ active }) => (
                                                        <a
                                                            href={option.href}
                                                            className={classNames(
                                                                option.current ? 'font-medium text-gray-900' : 'text-gray-500',
                                                                active ? 'bg-gray-100' : '',
                                                                'block px-4 py-2 text-sm'
                                                            )}
                                                        >
                                                            {option.name}
                                                        </a>
                                                    )}
                                                </Menu.Item>
                                            ))}
                                        </div>
                                    </Menu.Items>
                                </Transition>
                            </Menu>

                            <button type="button" className="-m-2 ml-5 p-2 text-white hover:text-[#E37B3A] sm:ml-7">
                                <span className="sr-only">View grid</span>
                                <Squares2X2Icon className="h-5 w-5" aria-hidden="true" />
                            </button>
                            
                            <button type="button" className="-m-2 ml-4 p-2 text-white hover:text-[#E37B3A] sm:ml-6 lg:hidden"
                                onClick={() => setMobileFiltersOpen(true)}>

                                <span className="sr-only">Filters</span>
                                <FunnelIcon className="h-5 w-5" aria-hidden="true" />
                            </button>

                        </div>

                    </div>

                    <section aria-labelledby="products-heading" className="bg-slate-600 pb-24 pt-6">
                        <div className="bg-orange-400 grid grid-cols-1 gap-x-8 gap-y-10 lg:grid-cols-4">
                            {/* Filters */}
                            <form className="hidden lg:block">
                                
                                <h2>Categoria 1</h2>
                                <ul role="list" className="space-y-4 border-b border-gray-200 pb-6 text-sm font-medium text-gray-900">
                                    {subCategories.map((category) => (
                                        <li key={category.name}>
                                            <a href={category.href}>{category.name}</a>
                                        </li>
                                    ))}
                                </ul>

                                {subMenus.map((section) => (

                                    <Disclosure as="div" key={section.id} className="border-b border-gray-200 py-6">
                                        {({ open }) => (
                                            <>
                                                <h3 className="-my-3 flow-root">
                                                    <Disclosure.Button className="flex w-full items-center justify-between bg-white py-3 text-sm text-gray-400 hover:text-gray-500">
                                                        <span className="font-medium text-gray-900">{section.name}</span>
                                                        <span className="ml-6 flex items-center">
                                                            {open ? (
                                                                <MinusIcon className="h-5 w-5" aria-hidden="true" />
                                                            ) : (
                                                                <PlusIcon className="h-5 w-5" aria-hidden="true" />
                                                            )}
                                                        </span>
                                                    </Disclosure.Button>
                                                </h3>
                                                <Disclosure.Panel className="pt-6">
                                                    <div className="space-y-4">
                                                        {section.options.map((option, optionIdx) => (
                                                            <div key={option.value} className="flex items-center">
                                                                <input
                                                                    id={`filter-${section.id}-${optionIdx}`}
                                                                    name={`${section.id}[]`}
                                                                    defaultValue={option.value}
                                                                    type="checkbox"
                                                                    defaultChecked={option.checked}
                                                                    className="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500"
                                                                />
                                                                <label
                                                                    htmlFor={`filter-${section.id}-${optionIdx}`}
                                                                    className="ml-3 text-sm text-gray-600"
                                                                >
                                                                    {option.label}
                                                                </label>
                                                            </div>
                                                        ))}
                                                    </div>
                                                </Disclosure.Panel>
                                            </>
                                        )}
                                    </Disclosure>

                                ))}

                            </form>

                            {/* Product grid */}
                            {/*INSPIRACION: https://mui.com/store/previews/minimal-dashboard-free/ */}
                            <div className="bg-white lg:col-span-3">{/* Your content */}
                                <div className="bg-green-500 py-24 sm:py-8">

                                    {/*Mensaje de bienvenida*/}
                                    <div className="bg-blue-500 mx-auto max-w-7xl px-10 lg:px-8">
                                        <h3 className='text-2xl text-white'>Bienvenido Dr. Chapatin</h3>
                                    </div>

                                    {/*Contenedor para mis etiquetas */}
                                    <div className="flex flex-row justify-around flex-wrap bg-red-500 py-5 px-6">
                                        {/*Para mis tarjetas etiquetas */}
                                        {stats.map((stat) => (
                                            <div key={stat.id} className="bg-slate-500 flex flex-row justify-start border border-white rounded-2xl w-48 h-24 my-2 mx-2">
                                                <div className='px-2 py-2'>
                                                    <img src={stat.icono} alt="icono-card" />
                                                </div>
                                                <div className='bg-green-800 flex flex-col justify-center'>
                                                    <h1 className='text-2xl'>{stat.valor}</h1>
                                                    <h1>{stat.titulo}</h1>
                                                </div>
                                            </div>
                                        ))}
                                        
                                    </div>

                                    {/*Contenedor para mis graficos estadisticos */}
                                    <div className="bg-yellow-300 mx-auto max-w-7xl px-6 lg:px-8">
                                        <div className="sm:mx-auto bg-slate-500 flex flex-row justify-start border border-white rounded-2xl h-72 my-2 mx-2 pt-16 sm:pt-0">
                                            <ResponsiveContainer width="100%" aspect={2}>
                                                <BarChart
                                                    data={data}
                                                    width={500}
                                                    height={400}
                                                    margin={{
                                                        top: 10,
                                                        right: 30,
                                                        left: 0,
                                                        bottom: 0
                                                    }}
                                                >
                                                    <CartesianGrid strokeDasharray="4 1 2" />
                                                    <XAxis dataKey="name" />
                                                    <YAxis />
                                                    <Tooltip />
                                                    <Legend />
                                                    <Bar dataKey="weight" fill="#6b48ff" />
                                                    <Bar dataKey="age" fill="#1ee3cf" />
                                                </BarChart>
                                            </ResponsiveContainer>
                                        </div>

                                        <div className="sm:mx-auto bg-slate-500 flex flex-row justify-start border border-white rounded-2xl h-72 my-2 mx-2 pt-16 sm:pt-0">
                                            <ResponsiveContainer width="100%" aspect={2}>
                                                <AreaChart
                                                    width={500}
                                                    height={400}
                                                    data={data}
                                                    margin={{
                                                        top: 10,
                                                        right: 30,
                                                        left: 0,
                                                        bottom: 0
                                                    }}
                                                >
                                                    <CartesianGrid strokeDasharray="3 3" />
                                                    <XAxis dataKey="name" />
                                                    <YAxis />
                                                    <Tooltip />
                                                    <Area type="monotone" dataKey="age" stackId="1" stroke='#8884d8' fill="#8884d8" />
                                                    <Area type="monotone" dataKey="weight" stackId="1" stroke='#82caed' fill="#fad3cf" />
                                                </AreaChart>
                                            </ResponsiveContainer>
                                        </div>


                                        <div className="sm:mx-auto bg-slate-500 flex flex-row justify-start border border-white rounded-2xl h-72 my-2 mx-2">
                                            <ResponsiveContainer>
                                                <PieChart>
                                                    <Pie
                                                        dataKey="value"
                                                        data={dataPay}
                                                        innerRadius={60}
                                                        outerRadius={120}
                                                        fill="#82ca9d"
                                                    >
                                                        {dataPay.map((entry, index) => (
                                                            <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
                                                        ))}
                                                    </Pie>
                                                    <Tooltip />
                                                </PieChart>
                                            </ResponsiveContainer>
                                        </div>


                                    </div>

                                </div>
                            </div>


                        </div>
                    </section>
                </main>

            </div>
        </div>
    )
}
